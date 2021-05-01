package ermilov.instattestmvpjava.views;

import java.util.ArrayList;

import ermilov.instattestmvpjava.models.videostreammodel.VideoStreamModel;
import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface VideoStreamView extends MvpView {
    public void onCompleteVideoStream(ArrayList<VideoStreamModel> arrayList);
    public void onErrorVideoStream(String message);
}
