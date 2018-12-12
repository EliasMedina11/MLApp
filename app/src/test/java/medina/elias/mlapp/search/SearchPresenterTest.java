package medina.elias.mlapp.search;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;


public class SearchPresenterTest {

    @Mock
    private
    SearchLandingPresenter presenter;

    @Mock
    private
    SearchLandingActivity view;

    @Before
    public void initMocks(){
        presenter = Mockito.mock(SearchLandingPresenter.class);
        view = Mockito.mock(SearchLandingActivity.class);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        presenter = new SearchLandingPresenter(view);
    }

    @Test
    public void searchValidator_CorrectQuery_ReturnsListOfResult () {
        presenter.doSearch("auto");
        Assert.assertFalse(presenter.getEmptyResults());
    }

    @Test
    public void searchValidator_IncorrectQuery_ReturnsEmptyList (){
        presenter.doSearch("$$$%%&/()");
        Assert.assertTrue(presenter.getEmptyResults());
    }
}
