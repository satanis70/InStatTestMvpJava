package ermilov.instattestmvpjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ermilov.instattestmvpjava.activities.VideoStreamActivity;
import ermilov.instattestmvpjava.models.matchinfomodels.MatchModel;
import ermilov.instattestmvpjava.presenters.MatchInfoPresenter;
import ermilov.instattestmvpjava.views.MathInfoView;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MathInfoView {

    @InjectPresenter
    MatchInfoPresenter matchInfoPresenter;
    TextView textViewTournament;
    TextView textViewTeam1;
    TextView textViewScoreTeam1;
    TextView textViewTeam2;
    TextView textViewScoreTeam2;
    TextView textViewMatchDate;
    Button buttonVideoStream1;
    Button buttonVideoStream2;
    Button buttonVideoStream3;
    Button buttonVideoStream4;
    ArrayList<Button> buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matchInfoPresenter.requestApi();
        textViewTournament = findViewById(R.id.tournament);
        textViewTeam1 = findViewById(R.id.team1);
        textViewScoreTeam1 = findViewById(R.id.score_team1);
        textViewTeam2 = findViewById(R.id.team2);
        textViewScoreTeam2 = findViewById(R.id.score_team2);
        textViewMatchDate = findViewById(R.id.match_date);
        buttonVideoStream1 = findViewById(R.id.button_translation1);
        buttonVideoStream2 = findViewById(R.id.button_translation2);
        buttonVideoStream3 = findViewById(R.id.button_translation3);
        buttonVideoStream4 = findViewById(R.id.button_translation4);
        buttons = new ArrayList<>();
        buttons.add(buttonVideoStream1);
        buttons.add(buttonVideoStream2);
        buttons.add(buttonVideoStream3);
        buttons.add(buttonVideoStream4);
        clickButton(buttons);

    }

    @Override
    public void onDataCompleteFromApi(MatchModel.Root root) {
        textViewTournament.setText(root.getTournament().name_rus);
        textViewTeam1.setText(root.getTeam1().name_rus);
        textViewScoreTeam1.setText(String.valueOf(root.getTeam1().score));
        textViewTeam2.setText(root.getTeam2().name_rus);
        textViewScoreTeam2.setText(String.valueOf(root.getTeam2().score));
        textViewMatchDate.setText(root.getDate());
    }

    @Override
    public void onDataErrorFromApi(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void clickButton(ArrayList<Button> buttonArrayList){
        Intent intent = new Intent(this, VideoStreamActivity.class);
        for (int i = 0; i < buttonArrayList.size(); i++) {
           buttonArrayList.get(i).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   startActivity(intent);
               }
           });
        }
    }
}