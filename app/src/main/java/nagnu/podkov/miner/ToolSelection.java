package nagnu.podkov.miner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ToolSelection extends AppCompatActivity {
    public int money;
    public int t;
    public int kk1;
    public int kk2;
    public int kk3;
    public int kk4;
    public int kk5;
    public String ok = "Ok";
//    public InterstitialAd interstitialAd;//Реклама
//    public InterstitialAd interstitialAd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hammerlevel);

//        //Реклама начало
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
//
//            }
//        });
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
//                new InterstitialAdLoadCallback() {
//                    @Override
//                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                        // Ссылка mInterstitialAd будет нулевой до тех пор, пока
//                        // реклама загружается.
//                        mInterstitialAd = interstitialAd;
//                        Log.i(TAG, "onAdLoaded");
//                    }
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error
//                        Log.d(TAG, loadAdError.toString());
//                        mInterstitialAd = null;
//                    }
//                });
//        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
//        interstitialAd=new InterstitialAd(this);
//        interstitialAd.setAdUnitId("ca-app-pub-4522346862586437/4482249455");
//        AdRequest adRequest=new AdRequest.Builder().build();
//        interstitialAd.loadAd(adRequest);
//        //Реклама конец

//        //Закрытие рекламы на крестик начало
//        interstitialAd.setAdListener(new AdListener(){
//            @Override
//            public void onAdClosed() {
//                try {
//                    //Условие
//                }catch (Exception e){}
//            }
//        });
//        //Закрытие рекламы на крестик конец

        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
        final int money1 = save.getInt("Money",0);
        final int tool1 = save.getInt("Tool",0);
        final int k1 = save.getInt("K1",1);
        final int k2 = save.getInt("K2",0);
        final int k3 = save.getInt("K3",0);
        final int k4 = save.getInt("K4",0);
        final int k5 = save.getInt("K5",0);

        money=money1;
        TextView text_money_shop = findViewById(R.id.text_money_shop);
        text_money_shop.setText("money  "+money+"");

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                //скрываем нижнюю панель навигации
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        //появляется поверх игры и изчезает

//___________________________________________________________________________________________
        //отображаем инструмент
        if (k1==1){
            if (tool1==0) {
                TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                price_tool_1.setText(ok);
            }else {
                TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                price_tool_1.setText(R.string.x1);
            }
        }
        if (k2==1){  //если инструмент куплен
            if (tool1==1){//если выбран
                TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                price_tool_2.setText(ok);
            }else {//если не выбран
                TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                price_tool_2.setText(R.string.x1);
            }
        }else {  //если не куплен
            TextView price_tool_2 = findViewById(R.id.tool_cost_2);
            price_tool_2.setText(R.string.x2);
        }
        if (k3==1){  //если инструмент куплен
            if (tool1==2){//если выбран
                TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                price_tool_3.setText(ok);
            }else {//если не выбран
                TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                price_tool_3.setText(R.string.x1);
            }
        }else {  //если не куплен
            TextView price_tool_3 = findViewById(R.id.tool_cost_3);
            price_tool_3.setText(R.string.x5);
        }
        if (k4==1){  //если инструмент куплен
            if (tool1==3){//если выбран
                TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                price_tool_4.setText(ok);
            }else {//если не выбран
                TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                price_tool_4.setText(R.string.x1);
            }
        }else {  //если не куплен
            TextView price_tool_4 = findViewById(R.id.tool_cost_4);
            price_tool_4.setText(R.string.x10);
        }
        if (k5==1){  //если инструмент куплен
            if (tool1==4){//если выбран
                TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                price_tool_5.setText(ok);
            }else {//если не выбран
                TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                price_tool_5.setText(R.string.x1);
            }
        }else {  //если не куплен
            TextView price_tool_5 = findViewById(R.id.tool_cost_5);
            price_tool_5.setText(R.string.x50);
        }
        //____________________________________________________________________
        kk1=k1;
        kk2=k2;
        kk3=k3;
        kk4=k4;
        kk5=k5;


        //нажатие на кнопки инструмента начало
        //Кнопка инструмент 1 начало
        CardView shop_tools1 = (CardView) findViewById(R.id.tools1);
        shop_tools1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Tool",0);
                editor.commit();
                t=0;
                kk1=1;
//                TextView sss = findViewById(R.id.sss);
//                sss.setText(k1+"+"+t);
                //отображаем инструмент
                if (kk1==1){
                    if (t==0) {
                        TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                        price_tool_1.setText(ok);
                    }else {
                        TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                        price_tool_1.setText(R.string.x1);
                    }
                }
                if (kk2==1){  //если инструмент куплен
                    if (t==1){//если выбран
                        TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                        price_tool_2.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                        price_tool_2.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                    price_tool_2.setText(R.string.x2);
                }
                if (kk3==1){  //если инструмент куплен
                    if (t==2){//если выбран
                        TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                        price_tool_3.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                        price_tool_3.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                    price_tool_3.setText(R.string.x5);
                }
                if (kk4==1){  //если инструмент куплен
                    if (tool1==3){//если выбран
                        TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                        price_tool_4.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                        price_tool_4.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                    price_tool_4.setText(R.string.x10);
                }
                if (kk5==1){  //если инструмент куплен
                    if (tool1==4){//если выбран
                        TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                        price_tool_5.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                        price_tool_5.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                    price_tool_5.setText(R.string.x50);
                }

            }
        });
        //Кнопка инструмент 1 конец

        //Кнопка инструмент 2 начало
        CardView shop_tools2 = (CardView) findViewById(R.id.tools2);
        shop_tools2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kk2==0 && money>=10000){
                    money=money-10000;
                    text_money_shop.setText("money  "+money+"");
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("K2",1);
                    editor.putInt("Money",money);
//                    editor.putInt("Tool", 1);
                    editor.commit();
//                    t=1;
                    kk2=1;
                }
                if (kk2==1) {
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("Tool", 1);
                    editor.commit();
                    t=1;
                }
                //отображаем инструмент
                if (kk1==1){
                    if (t==0) {
                        TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                        price_tool_1.setText(ok);
                    }else {
                        TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                        price_tool_1.setText(R.string.x1);
                    }
                }
                if (kk2==1){  //если инструмент куплен
                    if (t==1){//если выбран
                        TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                        price_tool_2.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                        price_tool_2.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                    price_tool_2.setText(R.string.x2);
                }
                if (kk3==1){  //если инструмент куплен
                    if (t==2){//если выбран
                        TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                        price_tool_3.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                        price_tool_3.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                    price_tool_3.setText(R.string.x5);
                }
                if (kk4==1){  //если инструмент куплен
                    if (tool1==3){//если выбран
                        TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                        price_tool_4.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                        price_tool_4.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                    price_tool_4.setText(R.string.x10);
                }
                if (kk5==1){  //если инструмент куплен
                    if (tool1==4){//если выбран
                        TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                        price_tool_5.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                        price_tool_5.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                    price_tool_5.setText(R.string.x50);
                }
            }
        });
        //Кнопка инструмент 2 конец

        //Кнопка инструмент 3 начало
        CardView shop_tools3 = (CardView) findViewById(R.id.tools5);
        shop_tools3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (k3==0 && money>=60000){
                    money=money-60000;
                    text_money_shop.setText("money  "+money+"");
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("K3",1);
                    editor.putInt("Money",money);
                    editor.putInt("Tool", 2);
                    editor.commit();
                    t=2;
                    kk3=1;
                }
                if (kk3==1) {
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("Tool", 2);
                    editor.commit();
                    t=2;
//                    kk3=1;
                }
                //отображаем инструмент
                if (kk1==1){
                    if (t==0) {
                        TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                        price_tool_1.setText(ok);
                    }else {
                        TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                        price_tool_1.setText(R.string.x1);
                    }
                }
                if (kk2==1){  //если инструмент куплен
                    if (t==1){//если выбран
                        TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                        price_tool_2.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                        price_tool_2.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                    price_tool_2.setText(R.string.x2);
                }
                if (kk3==1){  //если инструмент куплен
                    if (t==2){//если выбран
                        TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                        price_tool_3.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                        price_tool_3.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                    price_tool_3.setText(R.string.x5);
                }
                if (kk4==1){  //если инструмент куплен
                    if (tool1==3){//если выбран
                        TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                        price_tool_4.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                        price_tool_4.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                    price_tool_4.setText(R.string.x10);
                }
                if (kk5==1){  //если инструмент куплен
                    if (tool1==4){//если выбран
                        TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                        price_tool_5.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                        price_tool_5.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                    price_tool_5.setText(R.string.x50);
                }
            }
        });
        //Кнопка инструмент 3 конец

        //Кнопка инструмент 4 начало
        CardView shop_tools4 = (CardView) findViewById(R.id.tools10);
        shop_tools4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (k4==0 && money>=140000){
                    money=money-140000;
                    text_money_shop.setText("money  "+money+"");
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("K4",1);
                    editor.putInt("Money",money);
                    editor.putInt("Tool", 3);
                    editor.commit();
                    kk4=1;
//                    t=3;
                }
                if (kk4==1) {
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("Tool", 3);
                    editor.commit();
                    t=3;
                }
                //отображаем инструмент
                if (kk1==1){
                    if (t==0) {
                        TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                        price_tool_1.setText(ok);
                    }else {
                        TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                        price_tool_1.setText(R.string.x1);
                    }
                }
                if (kk2==1){  //если инструмент куплен
                    if (t==1){//если выбран
                        TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                        price_tool_2.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                        price_tool_2.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                    price_tool_2.setText(R.string.x2);
                }
                if (kk3==1){  //если инструмент куплен
                    if (t==2){//если выбран
                        TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                        price_tool_3.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                        price_tool_3.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                    price_tool_3.setText(R.string.x5);
                }
                if (kk4==1){  //если инструмент куплен
                    if (t==3){//если выбран
                        TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                        price_tool_4.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                        price_tool_4.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                    price_tool_4.setText(R.string.x10);
                }
                if (kk5==1){  //если инструмент куплен
                    if (t==4){//если выбран
                        TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                        price_tool_5.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                        price_tool_5.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                    price_tool_5.setText(R.string.x50);
                }
            }
        });
        //Кнопка инструмент 4 конец

        //Кнопка инструмент 5 начало
        CardView shop_tools5 = (CardView) findViewById(R.id.tools_50);
        shop_tools5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (k5==0 && money>=250000){
                    money=money-250000;
                    text_money_shop.setText("money  "+money+"");
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("K5",1);
                    editor.putInt("Money",money);
                    editor.putInt("Tool", 4);
                    editor.commit();
                    kk5=1;
//                    t=5;
                }
                if (kk5==1) {
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("Tool", 4);
                    editor.commit();
                    t=5;
                }
                //отображаем инструмент
                if (kk1==1){
                    if (t==0) {
                        TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                        price_tool_1.setText(ok);
                    }else {
                        TextView price_tool_1 = findViewById(R.id.tool_cost_1);
                        price_tool_1.setText(R.string.x1);
                    }
                }
                if (kk2==1){  //если инструмент куплен
                    if (t==1){//если выбран
                        TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                        price_tool_2.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                        price_tool_2.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_2 = findViewById(R.id.tool_cost_2);
                    price_tool_2.setText(R.string.x2);
                }
                if (kk3==1){  //если инструмент куплен
                    if (t==2){//если выбран
                        TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                        price_tool_3.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                        price_tool_3.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_3 = findViewById(R.id.tool_cost_3);
                    price_tool_3.setText(R.string.x5);
                }
                if (kk4==1){  //если инструмент куплен
                    if (t==3){//если выбран
                        TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                        price_tool_4.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                        price_tool_4.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_4 = findViewById(R.id.tool_cost_4);
                    price_tool_4.setText(R.string.x10);
                }
                if (kk5==1){  //если инструмент куплен
                    if (t==4){//если выбран
                        TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                        price_tool_5.setText(ok);
                    }else {//если не выбран
                        TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                        price_tool_5.setText(R.string.x1);
                    }
                }else {  //если не куплен
                    TextView price_tool_5 = findViewById(R.id.tool_cost_5);
                    price_tool_5.setText(R.string.x50);
                }
            }
        });
        //Кнопка инструмент 5 конец
        //нажатие на кнопки инструмента конец
        //______________________________________________________________________

//        //Кнопка + начало
        Button button_plus = (Button)findViewById(R.id.goto_shop);
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (interstitialAd.isLoaded()) {
//                    interstitialAd.show();//Показ рекламмы

                    money = money + 1000;
                    text_money_shop.setText("money  " + money + "");
                    SharedPreferences.Editor editor = save.edit();
                    editor.putInt("Money", money);
                    editor.commit();
//                }
            }
        });
//        //Кнопка + конец


                //Кнопка перехода в главное начало
        TextView textView = findViewById(R.id.back);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(ToolSelection.this,MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //Кнопка перехода в главное конец

    }

    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(ToolSelection.this,MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){}
    }
    //Системная кнопка "назад" - конец
}