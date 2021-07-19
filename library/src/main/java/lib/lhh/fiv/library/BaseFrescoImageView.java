package lib.lhh.fiv.library;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;

/**
 * Created by Linhh on 16/3/2.
 */
public interface BaseFrescoImageView {

    /**
     * 获得当前监听.
     *
     * @return ControllerListener
     */
    public ControllerListener getControllerListener();

    /**
     * 获得当前使用的DraweeController.
     *
     * @return DraweeController
     */
    public DraweeController getDraweeController();

    /**
     * 获得低级别ImageRequest.
     *
     * @return ImageRequest
     */
    public ImageRequest getLowImageRequest();

    /**
     * 获得当前使用的ImageRequest.
     *
     * @return ImageRequest
     */
    public ImageRequest getImageRequest();

    /**
     * 获得当前使用的RoundingParams.
     */
    public RoundingParams getRoundingParams();

    /**
     * 是否开启动画.
     *
     * @return boolean
     */
    public boolean isAnim();

    /**
     * 获得当前后处理.
     *
     * @return Postprocessor
     */
    public Postprocessor getPostProcessor();

    /**
     * 获得当前使用的默认图.
     *
     * @return int
     */
    public int getDefaultResID();

    /**
     * 获得当前加载的图片.
     *
     * @return String
     */
    public String getThumbnailUrl();

    /**
     * 获得当前低分辨率图片.
     *
     * @return String
     */
    public String getLowThumbnailUrl();

    /**
     * 获得加载的本地图片.
     *
     * @return String
     */
    public String getThumbnailPath();

    /**
     * 是否可以点击重试,默认false.
     *
     * @return boolean
     */
    public boolean getTapToRetryEnabled();

    /**
     * 是否自动旋转.
     *
     * @return boolean
     */
    public boolean getAutoRotateEnabled();
}
