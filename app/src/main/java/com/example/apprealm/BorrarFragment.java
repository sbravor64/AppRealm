package com.example.apprealm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apprealm.crud.CRUDUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class BorrarFragment extends Fragment {

    private Button buttonBorrar;
    private EditText editTextBorrarUser;

    public BorrarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_borrar, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //borrar
        editTextBorrarUser = view.findViewById(R.id.editTextBorrarUser);
        buttonBorrar = view.findViewById(R.id.buttonBorrar);

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextBorrarUser.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Inserte el id del usuario que quiere borrar", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    CRUDUser.deleteUserById(Integer.parseInt(editTextBorrarUser.getText().toString()));
                    Toast.makeText(getActivity(), "El usuario ha sido borrado con exito", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
