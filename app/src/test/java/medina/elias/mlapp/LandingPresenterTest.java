package medina.elias.mlapp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import medina.elias.mlapp.Service.RetroFitHelper;
import medina.elias.mlapp.landing.LandingFragment;
import medina.elias.mlapp.landing.LandingPresenter;

public class LandingPresenterTest {

    @Mock
    RetroFitHelper interactor;
    @Mock
    LandingFragment view;

    @Before

    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test

    public void testPresenterQuerySearch () throws Exception {
        LandingPresenter presenterLanding = new LandingPresenter(view);
    }
}
