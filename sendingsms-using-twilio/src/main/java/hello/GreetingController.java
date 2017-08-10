package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import java.util.ArrayList;
import java.util.List;
@Controller
public class GreetingController {
	
	 // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC73a23433564946d8215f8bd7d44d234a";
    public static final String AUTH_TOKEN = "e3b176a6c89a38fce153c2d7abab4187";
    public static final String TWILIO_NUMBER = "+16179256126";

    @RequestMapping("/index")
    public String greeting() {
    	sendSMS();
        return "greeting";
    }
    
    public void sendSMS() {
        try {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
     System.out.println("sivaram");
            // Build a filter for the MessageList
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("Body", "Hello, World!"));
            params.add(new BasicNameValuePair("To", "+14694121046")); //Add real number here
            params.add(new BasicNameValuePair("From", TWILIO_NUMBER));
     
            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            Message message = messageFactory.create(params);
            System.out.println(message.getSid());
        } 
        catch (TwilioRestException e) {
            System.out.println(e.getErrorMessage());
        }
    }

}