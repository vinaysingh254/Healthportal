package com.healthvision.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.healthvision.client.gin.ClientModule;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.gwt.inject.client.AsyncProvider;
import com.healthvision.client.home.HomePresenter;
import com.healthvision.client.home.SignupPresenter;
import com.healthvision.client.layout.HeaderPresenter;
import com.healthvision.client.dashborad.UserDashBoardPresenter;

@GinModules({DispatchAsyncModule.class, ClientModule.class})
public interface ClientGinjector extends Ginjector {

    EventBus getEventBus();

    PlaceManager getPlaceManager();

    AsyncProvider<HomePresenter> getHomePresenter();

    AsyncProvider<SignupPresenter> getSignupPresenter();

    AsyncProvider<HeaderPresenter> getHeaderPresenter();

    AsyncProvider<UserDashBoardPresenter> getUserDashBoardPresenter();}
