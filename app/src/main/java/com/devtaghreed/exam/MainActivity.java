package com.devtaghreed.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.devtaghreed.exam.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    ArrayList<Question_Answers>question=new ArrayList<>();
    int current_ques=0;
    Question_Answers q;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        question.add(new Question_Answers("Where’s the Eiffel Tower?","Egypt","London","Paris","Mexico","Paris"));
        question.add(new Question_Answers("What’s the largest Arab country by area?","Algeria","Morocco","Jordan","Qatar","Algeria"));
        question.add(new Question_Answers("Where’s the pyramids?","London","Egypt","Paris","Mexico","Egypt"));
        question.add(new Question_Answers("Where’s the Tower Bridge?","Egypt","Paris","London","Mexico","London"));
        fill_question();

        binding.rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int old_score=Integer.parseInt(binding.tvScore.getText().toString());
                int new_score;
                if (binding.rb1.getText().equals(q.getRight_ans())){
                    Toast.makeText(MainActivity.this, "Your Answer Is Right", Toast.LENGTH_SHORT).show();
                    new_score=old_score+1;
                }else {
                    Toast.makeText(MainActivity.this, "Your Answer Is False", Toast.LENGTH_SHORT).show();
                    new_score=old_score-1;
                }
                    current_ques++;
                    fill_question();
                    binding.tvScore.setText(String.valueOf(new_score));
            }
        }); binding.rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int old_score=Integer.parseInt(binding.tvScore.getText().toString());
                int new_score;
                if (binding.rb2.getText().equals(q.getRight_ans())){
                    Toast.makeText(MainActivity.this, "Your Answer Is Right", Toast.LENGTH_SHORT).show();
                    new_score=old_score+1;
                }else {
                    Toast.makeText(MainActivity.this, "Your Answer Is False", Toast.LENGTH_SHORT).show();
                    new_score=old_score;
                }
                current_ques++;
                fill_question();
                binding.tvScore.setText(String.valueOf(new_score));
            }
        }); binding.rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int old_score=Integer.parseInt(binding.tvScore.getText().toString());
                int new_score;
                if (binding.rb3.getText().equals(q.getRight_ans())){
                    Toast.makeText(MainActivity.this, "Your Answer Is Right", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Your Answer Is False", Toast.LENGTH_SHORT).show();
                    new_score=old_score-1;
                    binding.tvScore.setText(String.valueOf(new_score));

                }
                current_ques++;
                fill_question();
            }
        }); binding.rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int old_score=Integer.parseInt(binding.tvScore.getText().toString());
                int new_score;
                if (binding.rb4.getText().equals(q.getRight_ans())){
                    Toast.makeText(MainActivity.this, "Your Answer Is Right", Toast.LENGTH_SHORT).show();
                    new_score=old_score+1;
                }else {
                    Toast.makeText(MainActivity.this, "Your Answer Is False", Toast.LENGTH_SHORT).show();
                    new_score=old_score;
                }
                current_ques++;
                fill_question();
                binding.tvScore.setText(String.valueOf(new_score));
            }
        });

    }public void fill_question(){
        random=new Random();
        current_ques=random.nextInt(question.size());
        if (current_ques < question.size()){
        q = question.get(current_ques);
        binding.tvQuestion.setText(q.getQuestion());
        binding.rb1.setText(q.getAns1());
        binding.rb2.setText(q.getAns2());
        binding.rb3.setText(q.getAns3());
        binding.rb4.setText(q.getAns4());
        }else {
            Toast.makeText(this, "There’s No Question", Toast.LENGTH_SHORT).show();
        }question.remove(current_ques);
    }
}