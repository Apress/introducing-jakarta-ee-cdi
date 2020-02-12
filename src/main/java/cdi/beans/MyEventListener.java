package cdi.beans;

import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.event.TransactionPhase;

import cdi.annotations.CreateUserQualifier;
import cdi.annotations.InStoreQualifier;
import cdi.annotations.OnlineQualifier;
import jpa.entities.ApplicationUser;

public class MyEventListener {

//    void smsObserver(@Observes ApplicationUser applicationUser) {
//        try {
//            Thread.sleep(5000);
//            //Simulate sending SMS, which might be a long running task
//            //You get the user phone number from ApplicationUser#getMobileNumber()
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    void smsAsyncObserver(@ObservesAsync @OnlineQualifier ApplicationUser applicationUser) {
        try {
            Thread.sleep(5000);
            //Simulate sending SMS, which might be a long running task
            //You get the user phone number from ApplicationUser#getMobileNumber()

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    void smsInStore(@ObservesAsync @InStoreQualifier ApplicationUser applicationUser) {
        try {
            Thread.sleep(5000);
            //Simulate sending SMS, which might be a long running task
            //You get the user phone number from ApplicationUser#getMobileNumber()

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void sendEmail(@Observes(during = TransactionPhase.AFTER_SUCCESS)
                   @CreateUserQualifier ApplicationUser applicationUser) {
        //Send email using MessagingService
    }
}
