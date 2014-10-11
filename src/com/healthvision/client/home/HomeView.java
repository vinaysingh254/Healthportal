package com.healthvision.client.home;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class HomeView extends ViewImpl implements HomePresenter.MyView {

    private final Widget widget;
    @UiField Label userIdLabel;
    @UiField TextBox userid;
    @UiField Button logibButton;
    @UiField HTMLPanel ratePanel;

    public interface Binder extends UiBinder<Widget, HomeView> {}

    @Inject
    public HomeView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }
    @Override
    public Widget asWidget() {
        return widget;
    }
    @Override
    public Label getUserIdLabel() {
        return userIdLabel;
    }
    @Override
    public TextBox getUserid() {
        return userid;
    }
    @Override
    public Button getLogibButton() {
        return logibButton;
    }
    @Override
    public void setInSlot(Object slot, Widget content) {
        if(slot == HomePresenter.SLOT_rate){
            ratePanel.clear();
            if(ratePanel != null){
                ratePanel.add(content);
            }else{
                super.setInSlot(slot, content);
            }
        }
    }
}
