package com.example.chef;

import androidx.annotation.NonNull;

import com.example.chef.Activity.showActivity;
import com.example.chef.Models.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

import static com.example.chef.Activity.showActivity.adapter;
import static com.example.chef.Activity.showActivity.list;

public class databaseManager {
    public static String soup;
    public static String pasta;
    public static String meat;
    public static String rice;
    public static String chicken;
    public static String pastaOrRice;
    public static String meatOrChicken;
    public static String vegetable;
    public static String dessert;

    public interface IDatabase{
        void IDatabaseCallback(Object response);
    }

    public static void login(final String userNickName, final String userPassword, final  IDatabase callback)
    {
        if(userPassword.length()!=0 && userNickName.length()!=0){
                isNickNameExists(userNickName, new IDatabase() {
                    @Override
                    public void IDatabaseCallback(Object response) {
                        if((boolean) response==false) {
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            database.getReference("Users").orderByChild("userNickName").equalTo(userNickName).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        user userBeans = ds.getValue(user.class);
                                        if (userBeans.userPassword.equals(userPassword.trim()))
                                            callback.IDatabaseCallback(1);

                                        else
                                            callback.IDatabaseCallback(0);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                        }
                        else
                            callback.IDatabaseCallback(-1);
                    }
                });
            }
            else
                callback.IDatabaseCallback(-2);
    }
    public static void register(final String userNickName,final String userName, final String userSurname,final String userPassword ,final IDatabase callback) {
        if (userNickName.length() != 0 && userName.length() != 0 && userSurname.length() != 0 && userPassword.length() != 0) {
            isNickNameExists(userNickName, new IDatabase() {
            @Override
            public void IDatabaseCallback(Object response) {
                if ((boolean) response) {
                    if (userNickName.length() >= 3){
                        if (userPassword.length() >= 6 && userPassword.length() <= 10) {
                            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Users");
                            String id = myRef.push().getKey();
                            user u = new user(id, userNickName, userName, userSurname, userPassword);
                            myRef.child(id).setValue(u);
                            callback.IDatabaseCallback(1);
                        } else
                            callback.IDatabaseCallback(0);
                    }else
                    callback.IDatabaseCallback(-1);

                } else
                    callback.IDatabaseCallback(-2);
                }
            });
        }  else callback.IDatabaseCallback(-3);
    }
    public static void isNickNameExists(final String nickname,final IDatabase callback)
    {
        FirebaseDatabase database =FirebaseDatabase.getInstance();
        database.getReference("Users").orderByChild("userNickName").equalTo(nickname).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if(dataSnapshot.exists())
                    callback.IDatabaseCallback(false);
               else
                callback.IDatabaseCallback(true);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public static void menu(){

        final FirebaseDatabase d = FirebaseDatabase.getInstance();
        final Random random = new Random();
        d.getReference("Soups").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long soupCount;
                soupCount=dataSnapshot.getChildrenCount();
                final String soupRandom= String.valueOf((random.nextInt((int) soupCount+1)));
                d.getReference("Soups").orderByChild("numara").equalTo(soupRandom).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                            for(DataSnapshot ds:dataSnapshot1.getChildren())
                                soup=ds.child("name").getValue().toString();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        d.getReference("Pastas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long pastaCount;
                pastaCount=dataSnapshot.getChildrenCount();
                final String pastaRandom= String.valueOf((random.nextInt((int) pastaCount+1)));
                d.getReference("Pastas").orderByChild("numara").equalTo(pastaRandom).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                        for(DataSnapshot ds:dataSnapshot1.getChildren())
                            pasta=ds.child("name").getValue().toString();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        d.getReference("Rices").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long riceCount;
                riceCount=dataSnapshot.getChildrenCount();
                final String riceRandom= String.valueOf((random.nextInt((int) riceCount+1)));
                d.getReference("Rices").orderByChild("numara").equalTo(riceRandom).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                        for(DataSnapshot ds:dataSnapshot1.getChildren())
                            rice=ds.child("name").getValue().toString();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        d.getReference("Meats").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long meatCount;
                meatCount=dataSnapshot.getChildrenCount();
                final String meatRandom= String.valueOf((random.nextInt((int) meatCount+1)));
                d.getReference("Meats").orderByChild("numara").equalTo(meatRandom).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                        for(DataSnapshot ds:dataSnapshot1.getChildren())
                            meat=ds.child("name").getValue().toString();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        d.getReference("Chickens").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long chickenCount;
                chickenCount=dataSnapshot.getChildrenCount();
                final String chickenRandom= String.valueOf((random.nextInt((int) chickenCount+1)));
                d.getReference("Chickens").orderByChild("numara").equalTo(chickenRandom).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                        for(DataSnapshot ds:dataSnapshot1.getChildren())
                            chicken=ds.child("name").getValue().toString();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        d.getReference("Vegetables").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long vegetableCount;
                vegetableCount=dataSnapshot.getChildrenCount();
                final String vegetableRandom= String.valueOf((random.nextInt((int) vegetableCount+1)));
                d.getReference("Vegetables").orderByChild("numara").equalTo(vegetableRandom).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                        for(DataSnapshot ds:dataSnapshot1.getChildren())
                            vegetable=ds.child("name").getValue().toString();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        d.getReference("Desserts").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long dessertCount;
                dessertCount=dataSnapshot.getChildrenCount();
                final String dessertRandom= String.valueOf((random.nextInt((int) dessertCount+1)));
                d.getReference("Desserts").orderByChild("numara").equalTo(dessertRandom).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                        for(DataSnapshot ds:dataSnapshot1.getChildren())
                            dessert=ds.child("name").getValue().toString();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        setPastaOrRice();
        setMeatOrChicken();
    }
    public static void setPastaOrRice()
    {
        final Random random = new Random();
        final long rndm;
        rndm=random.nextInt(2);
        if(rndm==1)
            pastaOrRice=pasta;
        else
            pastaOrRice=rice;
    }
    public static void setMeatOrChicken()
    {    final Random random = new Random();
        final long rndm1;
        rndm1=random.nextInt(2);

        if(rndm1==1)
            meatOrChicken=meat;
        else
            meatOrChicken=chicken;
    }
    public static void show(DatabaseReference database){

            database.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    showActivity.list.clear();
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        showActivity.list.add(ds.child("name").getValue().toString());
                    }
                    showActivity.adapter.notifyDataSetChanged();
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
    }
    public static void add(final String type,final String name){

        DatabaseReference databaseReference =FirebaseDatabase.getInstance().getReference("Suggestions");
        databaseReference.child(type).push().child("name").setValue(name);

    }

}
