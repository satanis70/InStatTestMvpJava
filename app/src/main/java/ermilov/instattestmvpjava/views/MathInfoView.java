package ermilov.instattestmvpjava.views;

import ermilov.instattestmvpjava.models.matchinfomodels.MatchModel;
import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface MathInfoView extends MvpView {
    public void onDataCompleteFromApi(MatchModel.Root root);
    public void onDataErrorFromApi(String message);
}
