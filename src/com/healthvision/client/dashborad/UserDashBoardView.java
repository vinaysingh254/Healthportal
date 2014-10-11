package com.healthvision.client.dashborad;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class UserDashBoardView extends ViewImpl implements UserDashBoardPresenter.MyView {

    private final Widget widget;

    public interface Binder extends UiBinder<Widget, UserDashBoardView> {}

    @Inject
    public UserDashBoardView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }}
