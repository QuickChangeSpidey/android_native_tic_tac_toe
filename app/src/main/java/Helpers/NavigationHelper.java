package Helpers;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import com.example.akshay.ticktactoe.R;

public class NavigationHelper {

    public void createMenuForActivity(AppCompatActivity activity) {
        BottomNavigationView bottomNavigationView =
                activity.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_main:
                                Log.d("test", "test1");
                                break;
                            case R.id.action_history:
                                Log.d("test", "test1");
                                break;
                            case R.id.action_settings:
                                Log.d("test", "test2");
                                break;
                            case R.id.action_rules:
                                Log.d("test", "test3");
                                break;
                        }
                        return true;
                    }
                });
    }
}
