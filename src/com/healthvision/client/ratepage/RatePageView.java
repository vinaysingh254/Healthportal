package com.healthvision.client.ratepage;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class RatePageView extends ViewImpl implements RatePagePresenter.MyView {

    private final Widget widget;
    @UiField RadioButton yesButton;
    @UiField RadioButton noButton;

    public interface Binder extends UiBinder<Widget, RatePageView> {}

    @Inject
    public RatePageView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }
    @Override
    public Widget asWidget() {
        return widget;
    }
    @Override
    public RadioButton getYesButton() {
        return yesButton;
    }
    @Override
    public RadioButton getNoButton() {
        return noButton;
    }
}
