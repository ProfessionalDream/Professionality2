package com.professionaldream.professionality.data;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.professionaldream.professionality.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private FirebaseAuth mAuth;
    private Result<LoggedInUser> result;

    public Result<LoggedInUser> login(String username, String password, Activity worker) {
            FirebaseApp.initializeApp(worker);
            this.mAuth=FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(worker,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser user=mAuth.getCurrentUser();
                        LoggedInUser ruser=new LoggedInUser(user.getUid(),user.getDisplayName(),user.getEmail(),user.getPhotoUrl());

                        result=new Result.Success(ruser);
                    }
                    else{
                        result=new Result.Error(new IOException("Error logging in"));

                    }
                }
            });

            return result;
    }

    public void logout() {
        // TODO: revoke authentication
    }
}