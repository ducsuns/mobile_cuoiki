package com.example.mobile_cuoiki.readwrite;

import android.content.Context;

import com.example.mobile_cuoiki.model.Classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteClass {
    Context context;

    public ReadWriteClass(Context context) {
        this.context = context;
    }
    public void writeClass(Context context, String fname, Classes classes){

        ArrayList<Classes> list = new ArrayList<>();
        try {
            FileOutputStream f= context.openFileOutput(fname,Context.MODE_PRIVATE);
            ObjectOutputStream o =new ObjectOutputStream(f);
            list.add(classes);
            o.writeObject(list);
            f.close();
            o.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public List<Classes> readClass(Context context, String fname){
        ArrayList<Classes> list =new ArrayList<>();
        try {
            FileInputStream f=context.openFileInput(fname);


            ObjectInputStream o= new ObjectInputStream(f);
            list=(ArrayList<Classes>)o.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
