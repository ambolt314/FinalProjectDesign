using System.Net.Http;
using System.Net.Http.Headers;
using System.Windows;

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

        private void Btn_GenerateInvitationEmail_Click(object sender, RoutedEventArgs e)
        {
            renderEmail($"/visits-service/email/invitation-email?visitorID={Txt_InvitationVisitorID.Text}");
        }

        private void Btn_GenerateCLFVisitConfirmationEmail_Click(object sender, RoutedEventArgs e)
        {
            renderEmail($"/visits-service/email/cl-visit-confirmation?visitorID={Txt_CLFVisitorID.Text}&purposeID={Txt_CLFPurposeID.Text}&sessionID={Txt_CLFSessionID.Text}");
        }

        private void Btn_GenerateInsuranceNotification_Click(object sender, RoutedEventArgs e)
        {
            renderEmail($"/visits-service/email/insurance-notificationl?visitID={Txt_InsuranceVisitID.Text}");
        }

        

        private void Btn_SendEmail_Click(object sender, RoutedEventArgs e)
        {
            if (Txt_From.Text == "" || Txt_To.Text == "" || Txt_Cc.Text == "" || Txt_Subject.Text == "" || Txt_Body.Text == "")
            {
                Lbl_Warning.Visibility = Visibility.Visible;
            }
            else
            {
                MessageBox.Show($"Email successfully sent at {DateTime.Now}");
            }

        }


        private async void renderEmail(string uri)
        {

            loadProgress();
            string AUTH_TOKEN = "6576b737-41e5-41af-a0ad-3d8e94ad99d2";

            HttpClient client = new HttpClient();

            client.BaseAddress = new Uri("http://localhost:4012");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(
                new MediaTypeWithQualityHeaderValue("application/json"));
            client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", AUTH_TOKEN);

            Email email = null;
            HttpResponseMessage response = await client.GetAsync(uri);
            
            if (response.IsSuccessStatusCode)
            {
                email = await response.Content.ReadAsAsync<Email>();

                Lbl_Warning.Visibility = Visibility.Hidden;
                Txt_From.Text = $"{email.FromName} <{email.From}>";
                Txt_To.Text = $"{email.ToName} <{email.To}>";
                Txt_Cc.Text = email.CC;
                Txt_Subject.Text = email.Subject;
                Txt_Body.Text = email.Body;
            }
            else
            {
                pbStatus.Value = 0;
                Lbl_Warning.Content = "Email could not be generated";
                Lbl_Warning.Visibility = Visibility.Visible;
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


    }
}