package com.artur.assignment.service.patternServices;

import com.artur.assignment.observer.NewsContent;
import com.artur.assignment.observer.Reader;
import com.artur.assignment.observer.Subscriber;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    /*
    Praegu antud pattern töötab ainult main meetodis.
    Loodud Controller ja kaust vaadatega, hiljem täiendada neid.
    Lõpptulemus:
        - Subscriptions - tabel, kus on uudise topic ja selle jälgijad.
        - ?* seos Account tabeliga many to many
     */

    private NewsContent content;
    private Subscriber subscriber;

    public void updateContent(NewsContent content){
        content.updateContent();
    }


    public void subscribe(Subscriber subscriber, NewsContent content){
        content.subscribe(subscriber);
    }

    public void unsubscribe(Subscriber subscriber, NewsContent content) {
        content.unSubscribe(subscriber);
    }

    public void notifySubscribers(NewsContent content){
        content.notifySubscribers();
    }

}
