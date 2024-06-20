using System.Net.Http;
using System.Net.Http.Headers;
using System.Windows;
using System.Windows.Controls;

namespace EmailRenderer
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Btn_GenerateVisitConfirmationEmail_Click(object sender, RoutedEventArgs e)
        {
            string visitConfirmationURI = "/visits-service/emailDTO/";

            if (Cb_LTA.IsChecked == true)
            {
                visitConfirmationURI += "lta-";
            }

            if (Rb_CLF.IsChecked == true)
            {
                visitConfirmationURI += "clf";

            }
            else if (Rb_ISIS.IsChecked == true)
            {
                visitConfirmationURI += "isis";
            }
            else if (Rb_Other.IsChecked == true)
            {
                visitConfirmationURI += "other";
            }
            visitConfirmationURI += $"-visit-confirmation?visitorID={Txt_ConfirmationVisitorID.Text}&purposeID={Txt_ConfirmationPurposeID.Text}";

            if (Rb_Other.IsChecked != true)
            {
                visitConfirmationURI += $"&sessionID={Txt_ConfirmationSessionID.Text}";
            }

            renderEmail(visitConfirmationURI);
        }




        private void Btn_GenerateInsuranceNotification_Click(object sender, RoutedEventArgs e)
        {
            renderEmail($"/visits-service/emailDTO/insurance-notification?visitID={Txt_InsuranceVisitID.Text}");
        }

        private void Btn_GenerateInvitationEmail_Click(object sender, RoutedEventArgs e)
        {
            renderEmail($"/visits-service/emailDTO/invitation-emailDTO?visitorID={Txt_InvitationVisitorID.Text}");
        }


        private void Btn_GenerateRequestConfirmationEmail_Click(object sender, RoutedEventArgs e)
        {
            renderEmail($"");
        }
        

        private void Btn_SendEmail_Click(object sender, RoutedEventArgs e)
        {
            if (Txt_From.Text == "" || Txt_To.Text == "" || Txt_Cc.Text == "" || Txt_Subject.Text == "" || Txt_Body.Text == "")
            {
                Lbl_Warning.Visibility = Visibility.Visible;
                Lbl_Warning.FontSize = 16;
                Lbl_Warning.Content = "Please generate an email";
            }
            else
            {
                MessageBox.Show($"EmailDTO successfully sent at {DateTime.Now}");
            }

        }


        private async void renderEmail(string uri)
        {

            loadProgress();
            Lbl_Warning.Visibility = Visibility.Hidden;
            string AUTH_TOKEN = "6576b737-41e5-41af-a0ad-3d8e94ad99d2";

            HttpClient client = new HttpClient();

            client.BaseAddress = new Uri("http://localhost:4012");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(
                new MediaTypeWithQualityHeaderValue("application/json"));
            client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", AUTH_TOKEN);

            EmailDTO emailDTO = null;
            HttpResponseMessage response;
            try
            {
                response = await client.GetAsync(uri);
            }
            catch (HttpRequestException ex)
            {
                Lbl_Warning.Content = "Connection refused: please instantiate Docker container";
                Lbl_Warning.FontSize = 16;
                Lbl_Warning.Visibility = Visibility.Visible;
                pbStatus.Value = 0;
                return;
            }
            
            
            if (response.IsSuccessStatusCode)
            {
                emailDTO = await response.Content.ReadAsAsync<EmailDTO>();

                Lbl_Warning.Visibility = Visibility.Hidden;
                Txt_From.Text = $"{emailDTO.FromName} <{emailDTO.From}>";
                Txt_To.Text = $"{emailDTO.ToName} <{emailDTO.To}>";
                Txt_Cc.Text = emailDTO.CC;
                Txt_Subject.Text = emailDTO.Subject;
                Txt_Body.Text = emailDTO.Body;
            }
            else
            {
                pbStatus.Value = 0;
                Lbl_Warning.Content = "EmailDTO could not be generated";
                Lbl_Warning.Visibility = Visibility.Visible;
                Lbl_Warning.FontSize = 24;
                Txt_From.Text = "";
                Txt_To.Text = "";
                Txt_Cc.Text = "";
                Txt_Subject.Text = "";
                Txt_Body.Text = "";
            }

        }

        private void loadProgress()
        {
            pbStatus.Value = 0;
            while (pbStatus.Value < 100)
            {
                Thread.Sleep(10);
                pbStatus.Value += 10;
            }
        }

        private void Rb_Other_Checked(object sender, RoutedEventArgs e)
        {
            Txt_ConfirmationSessionID.Visibility = Visibility.Hidden;
            Txt_ConfirmationSessionID.IsReadOnly = true;

            Cb_LTA.Visibility = Visibility.Hidden;
            Cb_LTA.IsChecked = false;
        }

        private void Rb_Other_Unchecked(object sender, RoutedEventArgs e)
        {
            Txt_ConfirmationSessionID.Visibility = Visibility.Visible;
            Txt_ConfirmationSessionID.IsReadOnly = false;

            Cb_LTA.Visibility = Visibility.Visible;
            Cb_LTA.IsChecked = false;
        }
    }
}