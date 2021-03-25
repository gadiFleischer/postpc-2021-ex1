package android.exercise.mini.interactions;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditTitleActivity extends AppCompatActivity {

  boolean isEditing = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_title);
    // find all views
    FloatingActionButton fabStartEdit = findViewById(R.id.fab_start_edit);
    FloatingActionButton fabEditDone = findViewById(R.id.fab_edit_done);
    TextView textViewTitle = findViewById(R.id.textViewPageTitle);
    EditText editTextTitle = findViewById(R.id.editTextPageTitle);
    // setup - start from static title with "edit" button
    fabStartEdit.setVisibility(View.VISIBLE);
    fabEditDone.setVisibility(View.GONE);
    textViewTitle.setText("Page title here");
    textViewTitle.setVisibility(View.VISIBLE);
    editTextTitle.setText("Page title here");
    editTextTitle.setVisibility(View.GONE);
    // handle clicks on "start edit"
    fabStartEdit.setOnClickListener(v -> {
      isEditing=true;
      fabStartEdit.animate().alpha(0F).setDuration(500L).start();
      fabStartEdit.setVisibility(View.GONE);
      textViewTitle.setVisibility(View.GONE);
      fabEditDone.setVisibility(View.VISIBLE);
      //animation
      fabEditDone.setAlpha(0F);
      fabEditDone.animate().alpha(1F).setDuration(500L).start();
      editTextTitle.setVisibility(View.VISIBLE);
    });

    // handle clicks on "done edit"
    fabEditDone.setOnClickListener(v -> {
      isEditing=false;
      String newTitle = editTextTitle.getText().toString();
      textViewTitle.setText(newTitle);
      editTextTitle.setText(newTitle);
      //return to main activity
      fabEditDone.animate().alpha(0F).setDuration(500L).start();
      fabStartEdit.setVisibility(View.VISIBLE);
      textViewTitle.setVisibility(View.VISIBLE);
      fabEditDone.setVisibility(View.GONE);
      editTextTitle.setVisibility(View.GONE);
      //animation
      fabStartEdit.setAlpha(0F);
      fabStartEdit.animate().alpha(1F).setDuration(500L).start();
    });
  }

  @Override
  public void onBackPressed() {
    // find all views
    FloatingActionButton fabStartEdit = findViewById(R.id.fab_start_edit);
    FloatingActionButton fabEditDone = findViewById(R.id.fab_edit_done);
    TextView textViewTitle = findViewById(R.id.textViewPageTitle);
    EditText editTextTitle = findViewById(R.id.editTextPageTitle);
    if(isEditing){
      fabStartEdit.setVisibility(View.VISIBLE);
      textViewTitle.setVisibility(View.VISIBLE);
      fabEditDone.setVisibility(View.GONE);
      editTextTitle.setVisibility(View.GONE);
    }else{
      super.onBackPressed();
    }
  }
}