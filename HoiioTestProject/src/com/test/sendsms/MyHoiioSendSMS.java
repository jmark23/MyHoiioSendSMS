package com.test.sendsms;

import com.hoiio.sdk.Hoiio;
import com.hoiio.sdk.exception.HoiioException;
import com.hoiio.sdk.objects.sms.SmsTxn;

public class MyHoiioSendSMS {

	 private static String msg = "Hoiio test SMS... Have a nice day!";
	 private static final String dest = "+6598062771";
	 private static final String APP_ID = "ztzBWxmbbLPcpzcz";
	 private static final String ACCESS_TOKEN = "1fRgJ3XIAA6oxFI7";
     
	 public static void main(String[] args){
		 Hoiio hoiio = new Hoiio(APP_ID, ACCESS_TOKEN);
		 HoiioSendSmsImpl hsmsimpl = new HoiioSendSmsImpl();		 
		 hsmsimpl.sendSms(hoiio,dest,msg);	
	 
	 }    
}
class HoiioSendSmsImpl {

	void sendSms( Hoiio hoiio, String dest, String msg){
		 try {
			   //Send SMS
			   SmsTxn smsTxn = hoiio.getSmsService().send(dest, msg);    
		       // Response from Hoiio
			   System.out.println("Getting Hoiio Response... ");	
		       System.out.println("Hoiio Response >> " + smsTxn.getTxnRef());		     
		 } catch (HoiioException e) {
		        // Request doesn't return success_ok
		    	System.out.println("Request from Hoiio unsuccessfull!");
		        System.out.println("Hoiio Exception Status >> "+ e.getStatus().toString());
		        System.out.println("Hoiio Exception Content >> "+ e.getContent());
		    }		 
	 }
	
}