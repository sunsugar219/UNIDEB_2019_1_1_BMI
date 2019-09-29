package com.sunsugar.bmiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int sex = 0;
    float bmi = 1;
    int age;
    String tips;
    double help;
    float heightInt = 1;
    float weightInt = 1;
    String ideal;
    TextView suggestions;
	TextView mIndex;
    ImageView image = null;
    private static final String KEY_TIPS_VALUE = "tipsValue";
    private static final String KEY_BMI_VALUE = "bmiValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
	public void radioOne(View view) {
        //Is the button now checked?
        boolean checkedOne = ((RadioButton) view).isChecked();

        //Check which RadioButton was clicked
        switch (view.getId()) {
            case R.id.radio_man:
                if (checkedOne) {
                    sex = 0;
                    sex++;
                }
                break;


            case R.id.radio_woman:
                if (checkedOne) {
                    sex = 0;
                    sex = sex + 2;
                }
                break;
        }
    }
        public void count(View view) {

            for (int i = 1; i < 3; i++) {

                ImageView image = (ImageView) findViewById(R.id.cdc_pic);


                EditText height = (EditText) findViewById(R.id.height_input);
                String heightString = height.getText().toString();
                heightInt = Float.parseFloat(heightString);

                EditText weight = (EditText) findViewById(R.id.weight_input);
                String weightString = weight.getText().toString();
                weightInt = Float.parseFloat(weightString);

                bmi = weightInt / ((heightInt / 100) * (heightInt / 100));
                int bmiResult = Math.round(bmi);
                String results = getResources().getString(R.string.bmi_index) + bmiResult;

                mIndex = (TextView) findViewById(R.id.bmi_index);
                mIndex.setText(results);

                int btw = (int) help;
                ideal = Integer.toString(btw);

                EditText ageText = (EditText) findViewById(R.id.age_input);
                String ageString = ageText.getText().toString();
                age = Integer.parseInt(ageString);
                //hibák

                if (age > 150 || age == 0) {
                    String messageA = getResources().getString(R.string.check_age);
                    Toast.makeText(this, messageA, Toast.LENGTH_LONG).show();
                    return;
                }

                if (heightInt < 50 || heightInt > 300) {
                    String messageB = getResources().getString(R.string.check_height);
                    Toast.makeText(this, messageB, Toast.LENGTH_LONG).show();
                    return;
                }

                if (weightInt < 3 || weightInt > 700) {
                    String messageC = getResources().getString(R.string.check_weight);
                    Toast.makeText(this, messageC, Toast.LENGTH_LONG).show();
                    return;
                }


                //gyerekek bmi-je

                if (age <= 20 && sex == 1) {
                    tips = " ";
                    image.setVisibility(View.VISIBLE);
                    image.setImageResource(R.drawable.boys);
                }

                if (age <= 20 && sex == 2) {
                    tips = " ";
                    image.setVisibility(View.VISIBLE);
                    image.setImageResource(R.drawable.girls);
                }

                suggestions = (TextView) findViewById(R.id.tips_text);

                //nők bmi-je

                if (sex == 2) {
                    if (bmi < 18.5 && age > 20 && sex == 2) {
                        help = 18.5 * (heightInt / 100) * (heightInt / 100);
                        tips = getResources().getString(R.string.below_tips_a) + " " + ideal +
                                getResources().getString(R.string.below_tips_b);
                        image.setVisibility(View.GONE);
                        int advice = randomize();
                        switch (advice) {
                            case 1:
                                tips = tips + "\n" + getResources().getString(R.string.below_a);
                                break;
                            case 2:
                                tips = tips + "\n" + getResources().getString(R.string.below_b);
                                break;
                            case 3:
                                tips = tips + "\n" + getResources().getString(R.string.below_c);
                                break;
                            case 4:
                                tips = tips + "\n" + getResources().getString(R.string.below_d);
                                break;
                            case 5:
                                tips = tips + "\n" + getResources().getString(R.string.below_e);
                                break;
                            case 6:
                                tips = tips + "\n" + getResources().getString(R.string.below_f);
                                break;
                        }


                    } else if (18.5 <= bmi && bmi < 25 && age > 20 && sex == 2) {
                        help = 18.9 * (heightInt / 100) * (heightInt / 100);
                        tips = getResources().getString(R.string.normal_tips_a) + " " + ideal +
                                getResources().getString(R.string.normal_tips_b);
                        image.setVisibility(View.GONE);
                        int advice = randomize();
                        switch (advice) {
                            case 1:
                                tips = tips + "\n" + getResources().getString(R.string.normal_a);
                                break;
                            case 2:
                                tips = tips + "\n" + getResources().getString(R.string.normal_b);
                                break;
                            case 3:
                                tips = tips + "\n" + getResources().getString(R.string.normal_c);
                                break;
                            case 4:
                                tips = tips + "\n" + getResources().getString(R.string.normal_d);
                                break;
                            case 5:
                                tips = tips + "\n" + getResources().getString(R.string.normal_e);
                                break;
                            case 6:
                                tips = tips + "\n" + getResources().getString(R.string.normal_f);
                                break;
                        }

                    } else if (25 <= bmi && bmi < 30 && age > 20 && sex == 2) {
                        help = 24.5 * (heightInt / 100) * (heightInt / 100);
                        tips = getResources().getString(R.string.over_tips_a) + " " + ideal +
                                getResources().getString(R.string.over_tips_b);
                        image.setVisibility(View.GONE);
                        int advice = randomize();
                        switch (advice) {
                            case 1:
                                tips = tips + "\n" + getResources().getString(R.string.over_a);
                                break;
                            case 2:
                                tips = tips + "\n" + getResources().getString(R.string.over_b);
                                break;
                            case 3:
                                tips = tips + "\n" + getResources().getString(R.string.over_c);
                                break;
                            case 4:
                                tips = tips + "\n" + getResources().getString(R.string.over_d);
                                break;
                            case 5:
                                tips = tips + "\n" + getResources().getString(R.string.over_e);
                                break;
                            case 6:
                                tips = tips + "\n" + getResources().getString(R.string.over_f);
                                break;
                        }

                    } else if (30 <= bmi && age > 20 && sex == 2) {
                        help = 29.5 * (heightInt / 100) * (heightInt / 100);
                        double helpT = 24.5 * (heightInt / 100) * (heightInt / 100);
                        int btwT = (int) helpT;
                        String target = Integer.toString(btwT);
                        tips = getResources().getString(R.string.e_over_tips_a) + " " + ideal +
                                getResources().getString(R.string.e_over_tips_b) + " " +
                                target + getResources().getString(R.string.e_over_tips_c);
                        image.setVisibility(View.GONE);
                        int advice = randomize();
                        switch (advice) {
                            case 1:
                                tips = tips + "\n" + getResources().getString(R.string.e_over_a);
                                break;
                            case 2:
                                tips = tips + "\n" + getResources().getString(R.string.e_over_b);
                                break;
                            case 3:
                                tips = tips + "\n" + getResources().getString(R.string.e_over_c);
                                break;
                            case 4:
                                tips = tips + "\n" + getResources().getString(R.string.e_over_d);
                                break;
                            case 5:
                                tips = tips + "\n" + getResources().getString(R.string.e_over_e);
                                break;
                            case 6:
                                tips = tips + "\n" + getResources().getString(R.string.e_over_f);
                                break;
                        }

                    }
                }

                //férfiak bmi-je

                if (bmi < 22.5 && age > 20 && sex == 1) {
                    help = 22.5 * (heightInt / 100) * (heightInt / 100);
                    tips = getResources().getString(R.string.below_tips_a) + " " + ideal +
                            getResources().getString(R.string.below_tips_b);
                    ;
                    image.setVisibility(View.GONE);
                    int advice = randomize();
                    switch (advice) {
                        case 1:
                            tips = tips + "\n" + getResources().getString(R.string.below_a);
                            break;
                        case 2:
                            tips = tips + "\n" + getResources().getString(R.string.below_b);
                            break;
                        case 3:
                            tips = tips + "\n" + getResources().getString(R.string.below_c);
                            break;
                        case 4:
                            tips = tips + "\n" + getResources().getString(R.string.below_d);
                            break;
                        case 5:
                            tips = tips + "\n" + getResources().getString(R.string.below_e);
                            break;
                        case 6:
                            tips = tips + "\n" + getResources().getString(R.string.below_f);
                            break;
                    }

                } else if (22.5 <= bmi && bmi < 29 && age > 20 && sex == 1) {
                    help = 22.9 * (heightInt / 100) * (heightInt / 100);
                    tips = getResources().getString(R.string.normal_tips_a) + " " + ideal +
                            getResources().getString(R.string.normal_tips_b);
                    image.setVisibility(View.GONE);
                    int advice = randomize();
                    switch (advice) {
                        case 1:
                            tips = tips + "\n" + getResources().getString(R.string.normal_a);
                            break;
                        case 2:
                            tips = tips + "\n" + getResources().getString(R.string.normal_b);
                            break;
                        case 3:
                            tips = tips + "\n" + getResources().getString(R.string.normal_c);
                            break;
                        case 4:
                            tips = tips + "\n" + getResources().getString(R.string.normal_d);
                            break;
                        case 5:
                            tips = tips + "\n" + getResources().getString(R.string.normal_e);
                            break;
                        case 6:
                            tips = tips + "\n" + getResources().getString(R.string.normal_f);
                            break;
                    }

                } else if (29 <= bmi && bmi < 34 && age > 20 && sex == 1) {
                    help = 28.5 * (heightInt / 100) * (heightInt / 100);
                    tips = getResources().getString(R.string.over_tips_a) + " " + ideal +
                            getResources().getString(R.string.over_tips_b);
                    image.setVisibility(View.GONE);
                    int advice = randomize();
                    switch (advice) {
                        case 1:
                            tips = tips + "\n" + getResources().getString(R.string.over_a);
                            break;
                        case 2:
                            tips = tips + "\n" + getResources().getString(R.string.over_b);
                            break;
                        case 3:
                            tips = tips + "\n" + getResources().getString(R.string.over_c);
                            break;
                        case 4:
                            tips = tips + "\n" + getResources().getString(R.string.over_d);
                            break;
                        case 5:
                            tips = tips + "\n" + getResources().getString(R.string.over_e);
                            break;
                        case 6:
                            tips = tips + "\n" + getResources().getString(R.string.over_f);
                            break;
                    }

                } else if (34 <= bmi && age > 20 && sex == 1) {
                    help = 33.5 * (heightInt / 100) * (heightInt / 100);
                    double helpT = 28.5 * (heightInt / 100) * (heightInt / 100);
                    int btwT = (int) helpT;
                    String target = Integer.toString(btwT);
                    tips = getResources().getString(R.string.e_over_tips_a) + " " + ideal +
                            getResources().getString(R.string.e_over_tips_b) + " " +
                            target + getResources().getString(R.string.e_over_tips_c);
                    image.setVisibility(View.GONE);

                    int advice = randomize();
                    switch (advice) {
                        case 1:
                            tips = tips + "\n" + getResources().getString(R.string.e_over_a);
                            break;
                        case 2:
                            tips = tips + "\n" + getResources().getString(R.string.e_over_b);
                            break;
                        case 3:
                            tips = tips + "\n" + getResources().getString(R.string.e_over_c);
                            break;
                        case 4:
                            tips = tips + "\n" + getResources().getString(R.string.e_over_d);
                            break;
                        case 5:
                            tips = tips + "\n" + getResources().getString(R.string.e_over_e);
                            break;
                        case 6:
                            tips = tips + "\n" + getResources().getString(R.string.e_over_f);
                            break;
                    }
                }

            }
        suggestions.setText(tips);
    }


    public int randomize() {
        String random = "123456";
        Random r = new Random();
        char extra = random.charAt(r.nextInt(random.length()));
        int extraInt = Character.getNumericValue(extra);
        return extraInt;

    }
}
