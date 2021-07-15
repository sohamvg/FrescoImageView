package com.lhh.frescoimageview.demo;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.request.Postprocessor;
import lib.lhh.fiv.library.FrescoImageView;
import lib.lhh.fiv.library.FrescoZoomImageView;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.components.Attr;
import ohos.agp.components.AttrSet;
import ohos.app.Context;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class FrescoZoomImageOhosTest {
    private FrescoZoomImageView frescoZoomImageView;
    private Context context;

    private final AttrSet attrSet = new AttrSet() {
        @Override
        public Optional<String> getStyle() {
            return Optional.empty();
        }

        @Override
        public int getLength() {
            return 0;
        }

        @Override
        public Optional<Attr> getAttr(int i) {
            return Optional.empty();
        }

        @Override
        public Optional<Attr> getAttr(String s) {
            return Optional.empty();
        }
    };

    @Before
    public void setup() {
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        frescoZoomImageView = new FrescoZoomImageView(context, attrSet);
    }

    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("com.lhh.frescoimageview.demo", actualBundleName);
    }

    @Test
    public void testAnim() {
        assertTrue(frescoZoomImageView.isAnim());
        frescoZoomImageView.setAnim(false);
        assertFalse(frescoZoomImageView.isAnim());
    }

    @Test
    public void testAutoRotateEnabled() {
        assertFalse(frescoZoomImageView.getAutoRotateEnabled());
        frescoZoomImageView.setAutoRotateEnabled(true);
        assertTrue(frescoZoomImageView.getAutoRotateEnabled());
    }

    @Test
    public void testTapToRetryEnabled() {
        assertFalse(frescoZoomImageView.getTapToRetryEnabled());
        frescoZoomImageView.setTapToRetryEnabled(true);
        assertTrue(frescoZoomImageView.getTapToRetryEnabled());
    }

    @Test
    public void testDefaultResID() {
        String url = "https://avatars1.githubusercontent.com/u/8758713?v=3&s=460";
        frescoZoomImageView.loadView(url,5);
        assertEquals(5,frescoZoomImageView.getDefaultResID());
    }

    @Test
    public void testPostprocessor() {
        Postprocessor postProcessor = null;
        frescoZoomImageView.setPostProcessor(postProcessor);
        assertEquals(postProcessor,frescoZoomImageView.getPostProcessor());
    }

    @Test
    public void testControllerListener() {
        ControllerListener controllerListener = null;
        frescoZoomImageView.setControllerListener(controllerListener);
        assertEquals(controllerListener,frescoZoomImageView.getControllerListener());
    }

//    @Test
//    public void testThumbnailPath() {
//        frescoZoomImageView.loadLocalImage("file://path",0);
//        assertEquals("file://path",frescoZoomImageView.getThumbnailPath());
//    }

    @Test
    public void testThumbnailUrl() {
        String url = "https://avatars1.githubusercontent.com/u/8758713?v=3&s=460";
        frescoZoomImageView.loadView(url,url,0);
        assertEquals(url,frescoZoomImageView.getThumbnailUrl());
    }

    @Test
    public void testLowThumbnailUrl() {
        String url = "https://avatars1.githubusercontent.com/u/8758713?v=3&s=460";
        frescoZoomImageView.loadView(url,url,0);
        assertEquals(url,frescoZoomImageView.getLowThumbnailUrl());
    }

    @Test
    public void testAsCircle() {
        RoundingParams roundingParams = frescoZoomImageView.getRoundingParams();
        roundingParams.setRoundAsCircle(true);
        frescoZoomImageView.asCircle();
        assertEquals(roundingParams, frescoZoomImageView.getRoundingParams());
    }
}