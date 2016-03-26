package lywalton_portfolio.httpbit.fragmentui;

import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {

    boolean FistToSecond = true; //True = First to second, False = Second

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        /*
        if (findViewById(R.id.fragment_container) !=null)
        {
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            ItemList firstFragment = new ItemList();
            FacePicture secondFragment = new FacePicture();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,firstFragment).commit();


        }
        */

        Button butSwitchFragments = (Button) findViewById(R.id.button_switchFragements);

        assert butSwitchFragments != null;
        butSwitchFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FistToSecond)
                {
                    FacePicture secondFragment = new FacePicture();
                    FragmentTransaction newTransaction = getSupportFragmentManager().beginTransaction();

                    newTransaction.replace(R.id.fragment_container,secondFragment);
                    newTransaction.addToBackStack(null);
                    newTransaction.commit();


                    FistToSecond = false;
                }
                else if(!FistToSecond)
                {
                    ItemList firstFragment = new ItemList();
                    FragmentTransaction newTransaction = getSupportFragmentManager().beginTransaction();

                    newTransaction.replace(R.id.fragment_container,firstFragment);
                    newTransaction.addToBackStack(null);
                    newTransaction.commit();

                    FistToSecond = true;
                }
            }
        });
    }
}
