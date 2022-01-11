package com.example.project_comfort_01;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import ServicePackage.ComfortInterface;

import static org.mockito.Mockito.*;

public class ComfortPresenterTest {
    @Mock
    ComfortContractor.View view;
    @Mock
    ComfortInterface comfortInterface;
    @Mock
    ComfortContractor.Model model;
    @Mock
    ComfortPresenter presenter;
    @Mock
    MainFragment mainFragment;
    @InjectMocks
    ComfortPresenter comfortPresenter;



    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTempUP() throws Exception {
        presenter.TempUP(0);

       }

    @Test
    public void testTempDown() throws Exception {
        presenter.TempDown(0);

    }

    @Test
    public void testPowerClick() throws Exception {
        when(model.powerValue(anyBoolean())).thenReturn(Boolean.TRUE);

        presenter.PowerClick(true);
        when(presenter.PowerClick(true)).thenCallRealMethod();
        view.PowerOn();
        verify(view).PowerOn();

    }

    @Test
    public void testMaxACclick() throws Exception {
        when(model.maxAcValue(anyBoolean())).thenReturn(Boolean.TRUE);
        when(model.getMaxList()).thenReturn(Arrays.<String>asList("String"));
        presenter.MaxACclick(Boolean.TRUE);
        view.MaxChange();
        verify(view,times(1)).MaxChange();

    }

    @Test
    public void testAutoClick() throws Exception {
        when(model.AutoValue(anyBoolean())).thenReturn(Boolean.TRUE);
        when(model.getAutoList()).thenReturn(Arrays.<String>asList("String"));

        presenter.AutoClick(true);
    }

    @Test
    public void testSpeed1click() throws Exception {
        presenter.speed1click(0);
    }

    @Test
    public void testAcclick() throws Exception {
        when(model.acvalue(anyBoolean())).thenReturn(Boolean.TRUE);

     presenter.acclick(true);
    }

    @Test
    public void testTempprogress() throws Exception {
        presenter.tempprogress(0);
    }

    @Test
    public void testDefrostclick() throws Exception {
        when(model.DefrostValue(anyBoolean())).thenReturn(Boolean.TRUE);
        when(model.getDefrostList()).thenReturn(Arrays.<String>asList("String"));


        presenter.defrostclick(true);
    }

    @Test
    public void testRearclick() throws Exception {
        when(model.RearfrostValue(anyBoolean())).thenReturn(Boolean.TRUE);
        presenter.rearclick(true);
    }

    @Test
    public void testCheckcnnctn() throws Exception {
        presenter.checkcnnctn(true);
    }
}

