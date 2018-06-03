package com.example.akshay.ticktactoe.Views.Helpers;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.example.akshay.ticktactoe.R;
import com.example.akshay.ticktactoe.Views.Fragments.FAQFragment;
import com.example.akshay.ticktactoe.Views.Fragments.HistoryFragment;
import com.example.akshay.ticktactoe.Views.Fragments.LoginFragment;
import com.example.akshay.ticktactoe.Views.RulesActivity;

public class NavigationHelper {

    public void createMenuForActivity(final AppCompatActivity activity) {
        BottomNavigationView bottomNavigationView =
                activity.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_main:
                                activity.getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container_main,new LoginFragment())
                                        .addToBackStack(null)
                                        .commit();
                                break;
                            case R.id.action_history:
                                activity.getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container_main,new HistoryFragment())
                                        .addToBackStack(null)
                                        .commit();
                                break;
                            case R.id.action_faq:
                                activity.getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container_main,new FAQFragment())
                                        .addToBackStack(null)
                                        .commit();
                                break;
                        }
                        return true;
                    }
                });
    }

    public void goToRulesActivity(AppCompatActivity context){
        Intent intent = new Intent(context, RulesActivity.class);
        context.startActivity(intent);
    }
}
