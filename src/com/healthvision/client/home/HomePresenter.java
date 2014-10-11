package com.healthvision.client.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.healthvision.client.TokenParameter;
import com.healthvision.client.layout.HeaderPresenter;
import com.healthvision.client.place.NameTokens;
import com.healthvision.client.ratepage.RatePagePresenter;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

    public static final Object SLOT_rate = new Object();

    public interface MyView extends View {

        public Label getUserIdLabel();
        public TextBox getUserid();
        public Button getLogibButton();
    }
    @ProxyCodeSplit
    @NameToken(NameTokens.homepage)
    public interface MyProxy extends ProxyPlace<HomePresenter> {}

    @Inject PlaceManager placeManager;
    @Inject private RatePagePresenter ratePagePresenter;

    @Inject
    public HomePresenter(
            final EventBus eventBus,
            final MyView view,
            final MyProxy proxy) {
        super(eventBus, view, proxy);
    }
    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, HeaderPresenter.SLOT_content, this);
    }
    @Override
    protected void onBind() {
        super.onBind();
        getView().getLogibButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                PlaceRequest request = new PlaceRequest(NameTokens.signup);
                request = request.with(TokenParameter.NAME, getView().getUserid().getText());
                placeManager.revealPlace(request);
            }
        });
    }
    @Override
    protected void onReset() {
        super.onReset();
        setInSlot(SLOT_rate, ratePagePresenter);
        getView().getUserid().setText("Email Id");
    }
}
