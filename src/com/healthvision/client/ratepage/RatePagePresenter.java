package com.healthvision.client.ratepage;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class RatePagePresenter extends PresenterWidget<RatePagePresenter.MyView> {

    public interface MyView extends View {

        public RadioButton getYesButton();
        public RadioButton getNoButton();
    }

    @Inject
    public RatePagePresenter(
            final EventBus eventBus,
            final MyView view) {
        super(eventBus, view);
    }
    @Override
    protected void onBind() {
        super.onBind();
        getView().getYesButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Window.alert("That's great!");
            }
        });
        getView().getNoButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Window.alert("I'm sorry to hear that");
            }
        });
    }
}
