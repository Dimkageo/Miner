package nagnu.podkov.miner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//для рекламы
public class MainActivity extends AppCompatActivity {

    private AdView mAdView;//Банер
    private final String TAG = "MainActivity";

    private long backPressedTime;
    private Toast backToast;
    private int t;
    public int count;
    public int gold;
    public int money;
    public int t1;
    ProgressBar progressBar;
    public int numeStone; //переменная картинки камня
    Array array = new Array();


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //вставляем рекламу банер начало
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest2);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                // Код, который будет выполняться в случае сбоя запроса объявления.
                Log.d(TAG, "сбоя запроса объявления банера.________________________________________________________________________________________________________________________");
            }
            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded for an ad.
                // Код, который должен выполняться при регистрации показа объявления.
                Log.d(TAG, "регистрации показа объявления.________________________________________________________________________________________________________________________");
            }
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                // Код, который будет выполнен после завершения загрузки объявления.
                Log.d(TAG, "завершения загрузки объявления.________________________________________________________________________________________________________________________");
            }
            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that covers the screen.
                // Код, который будет выполняться, когда объявление открывает оверлей, закрывающий экран.
                Log.d(TAG, "объявление открывает оверлей, закрывающий экран.________________________________________________________________________________________________________________________");
            }
        });


        //вставляем рекламу банер конец

    SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
    final int money1 = save.getInt("Money",0);
    final int count1 = save.getInt("Count",0);
    final int stone1 = save.getInt("Stone",20);
//    final int gold1 = save.getInt("Gold",20);
    final int tool1 = save.getInt("Tool",0);

    //______________________________________________________________________
    Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                //скрываем нижнюю панель навигации
        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                //появляется поверх игры и изчезает
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                //выключили ночную тему
        setContentView(R.layout.activity_main);
        //___________________________________________________________________

        money=money1;
        TextView text_money = findViewById(R.id.text_money);
        text_money.setText("money  "+money+"");

        count=count1;
        progressBar = findViewById(R.id.progress);
        progressBar.setProgress(count);

        numeStone = stone1;
        t=tool1;
        if (tool1==0){
            t1=1;
        } else if (tool1==1) {
            t1=2;
        }else if (tool1==2) {
            t1=5;
        }else if (tool1==3) {
            t1=10;
        }else if (tool1==4) {
            t1=50;
        }

        //Вид кнопки магазин инструмента начало
        ImageView img_tool_shop = findViewById(R.id.tool_img);
        img_tool_shop.setImageResource((array.img_tool1[t]));
        TextView text_tool_shop = findViewById(R.id.tool_txt);
        text_tool_shop.setText(array.name_tool[t]);
        //Вид кнопки магазин инструмента конец

        ImageView img_stone = findViewById(R.id.img_stone);
        img_stone.setImageResource((array.images1[numeStone]));

        // Обрабатываем нажатие на картинку начало
        img_stone.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касания картинки начало
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //Если коснулся картинки начало
                    if (numeStone==0){
                        count=0;
                        numeStone=20;
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Gold",gold);
                        editor.commit();
                    }

                    count=count+1*t1;
                    money=money+1*t1;
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("Money",money);
                    editor.commit();
                    editor.putInt("Count",count);
                    editor.commit();

                    text_money.setText("money  "+money+"");
                    progressBar.setProgress(count);

                    v.animate().scaleX(0.90f).scaleY(0.9f).setDuration(0);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    //Если отпустил палец начало
                    v.animate().scaleX(1f).scaleY(1f).setDuration(0);
                    double l1 = 42;

                    for (int i=19; i>=0; i--){
                        if (l1<=count && count<(l1*1.7)){
                            numeStone=i;
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Stone",numeStone);
                            editor.commit();
                            img_stone.setImageResource((array.images1[numeStone]));
                        }
                        l1=l1*1.7;
                    }
                }
                //Условие касания картинки конец
                return true;
            }
        });
        // Обрабатываем нажатие на картинку конец



        //Кнопка перехода в магазин начало
        CardView buttonShop = (CardView) findViewById(R.id.tools);
        buttonShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Intent intent = new Intent(MainActivity.this,ToolSelection.class);
                    startActivity(intent);finish();
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //Кнопка перехода в магазин конец


    }
    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed() {

        if (backPressedTime +2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast=Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    //Системная кнопка "назад" - конец
}