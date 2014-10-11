package com.healthvision.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.healthvision.client.place.ClientPlaceManager;
import com.healthvision.client.home.HomePresenter;
import com.healthvision.client.home.HomeView;
import com.healthvision.client.place.DefaultPlace;
import com.healthvision.client.place.NameTokens;
import com.healthvision.client.home.SignupPresenter;
import com.healthvision.client.home.SignupView;
import com.healthvision.client.layout.HeaderPresenter;
import com.healthvision.client.layout.HeaderView;
import com.healthvision.client.dashborad.UserDashBoardPresenter;
import com.healthvision.client.dashborad.UserDashBoardView;
import com.healthvision.client.ratepage.RatePagePresenter;
import com.healthvision.client.ratepage.RatePageView;

public class ClientModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new DefaultModule(ClientPlaceManager.class));

        bindPresenter(HomePresenter.class, HomePresenter.MyView.class, HomeView.class, HomePresenter.MyProxy.class);

        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.homepage);

        bindPresenter(SignupPresenter.class, SignupPresenter.MyView.class, SignupView.class, SignupPresenter.MyProxy.class);

        bindPresenter(HeaderPresenter.class, HeaderPresenter.MyView.class, HeaderView.class, HeaderPresenter.MyProxy.class);

        bindPresenter(UserDashBoardPresenter.class, UserDashBoardPresenter.MyView.class, UserDashBoardView.class, UserDashBoardPresenter.MyProxy.class);

        bindPresenterWidget(RatePagePresenter.class, RatePagePresenter.MyView.class, RatePageView.class);
    }}
