package com.example.apprealm.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apprealm.R;
import com.example.apprealm.crud.CRUDUser;
import com.example.apprealm.model.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertarFragment extends Fragment {

    NavController navController;

    private EditText editTextNombreUser;
    private EditText editTextEdadUser;
    private EditText editTextApellidos;
    private EditText editTextDireccion;
    private EditText editTextTelefono;
    private Button buttonInsertar;


    private User user;

    public InsertarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insertar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        //insert
        editTextEdadUser = view.findViewById(R.id.editTextEdad);
        editTextNombreUser = view.findViewById(R.id.editTextNombre);
        editTextApellidos = view.findViewById(R.id.editTextApellidos);
        editTextDireccion = view.findViewById(R.id.editTexDireccion);
        editTextTelefono = view.findViewById(R.id.editTextTelefono);
        buttonInsertar = view.findViewById(R.id.buttonInsertar);

        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextEdadUser.getText().toString().matches("") ||
                        editTextNombreUser.getText().toString().matches("") ||
                        editTextApellidos.getText().toString().matches("") ||
                        editTextDireccion.getText().toString().matches("") ||
                        editTextTelefono.getText().toString().matches("")){
                    Toast.makeText(getActivity(), "Rellene los datos del usuario para insertarlo", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    user = new User(editTextNombreUser.getText().toString(),
                            editTextApellidos.getText().toString(),
                            editTextEdadUser.getText().toString(),
                            editTextDireccion.getText().toString(),
                            Integer.parseInt(editTextTelefono.getText().toString()));

//                    user.setNombre(editTextNombreUser.getText().toString());
//                    user.setEdad(editTextEdadUser.getText().toString());
                    CRUDUser.addUser(user);
                    Toast.makeText(getActivity(), "Usuario añadido con éxito", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
