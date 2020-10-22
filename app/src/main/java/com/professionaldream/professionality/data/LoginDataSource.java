package com.professionaldream.professionality.data;

import android.app.Activity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.professionaldream.professionality.DataHolder;
import com.professionaldream.professionality.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private Result<LoggedInUser> result;

    public Result<LoggedInUser> login(String username, String password, final Activity worker) {
            FirebaseApp.initializeApp(worker);
            DataHolder.Auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(worker,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser user=DataHolder.Auth.getCurrentUser();
                        LoggedInUser ruser=new LoggedInUser(user.getUid(),user.getDisplayName(),user.getEmail(),user.getPhotoUrl());

                        result=new Result.Success(ruser);
                    }
                    else{
                        Toast.makeText(worker.getBaseContext(),task.getException().toString(),Toast.LENGTH_LONG).show();
                        result=new Result.Error(task.getException());

                    }
                }
            });
            return result;
    }

    public void logout() {
        DataHolder.Auth.signOut();
    }
}