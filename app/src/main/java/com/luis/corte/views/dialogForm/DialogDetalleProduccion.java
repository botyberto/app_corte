package com.luis.corte.views.dialogForm;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.luis.corte.Controlers.Controlador;
import com.luis.corte.R;
import com.luis.corte.models.Trabajadores;
import com.luis.corte.views.adaptadores.ListaReporteDetalleAdapter;

public class DialogDetalleProduccion extends AlertDialog {
    private Controlador  controlador;
    private Trabajadores trabajador;
    private TextView tvConsecutivo;
    private TextView tvTrabajador;
    private ListView lvDetalleProduccion;
    private Context context;
    private Button btn_salir;

    public DialogDetalleProduccion(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_detalle_produccion);
        tvTrabajador = (TextView) findViewById(R.id.tv_trabajador_detalleReporte);
        tvConsecutivo = (TextView) findViewById(R.id.tv_consecutivo_detalleReporte);
        lvDetalleProduccion = (ListView) findViewById(R.id.lv_detalle_detalleReporte);
        this.btn_salir = (Button) findViewById(R.id.btn_salir_dialog);

        tvTrabajador.setText(trabajador.getTrabajador());
        tvConsecutivo.setText("Consecutivo: "+trabajador.getConsecutivo());

        ListaReporteDetalleAdapter adapter = new ListaReporteDetalleAdapter(context,controlador.getReporteDetalleTrabajador(trabajador));
        lvDetalleProduccion.setAdapter(adapter);

        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setControlador(Controlador controlador, Trabajadores trabajador) {
        this.controlador = controlador;
        this.trabajador = trabajador;
    }
}
