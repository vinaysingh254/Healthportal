package com.healthvision.client.home;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class SignupView extends ViewImpl implements SignupPresenter.MyView {

    private final Widget widget;
    @UiField Label signUpLabel;

    public interface Binder extends UiBinder<Widget, SignupView> {}

    @Inject
    public SignupView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }
    @Override
    public Widget asWidget() {
        return widget;
    }

    @Override
    public Label getSignUpLabel() {
        return signUpLabel;
    }
}
