package com.healthvision.client.layout;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class HeaderView extends ViewImpl implements HeaderPresenter.MyView {

    private final Widget widget;
    @UiField HTMLPanel contentPanel;

    public interface Binder extends UiBinder<Widget, HeaderView> {}

    @Inject
    public HeaderView(final Binder binder) {
        widget = binder.createAndBindUi(this);
    }
    @Override
    public Widget asWidget() {
        return widget;
    }
    @Override
    public void setInSlot(Object slot, Widget content) {
        if(slot == HeaderPresenter.SLOT_content){
            contentPanel.clear();
            if(contentPanel != null){
                contentPanel.add(content);
            }else{
                super.setInSlot(slot, content);
            }
        }
    }
}
