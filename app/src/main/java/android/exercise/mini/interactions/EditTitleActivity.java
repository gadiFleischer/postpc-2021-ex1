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
      fabStartEdit.setVisibility(View.GONE);
      textViewTitle.setVisibility(View.GONE);
      fabEditDone.setVisibility(View.VISIBLE);
      editTextTitle.setVisibility(View.VISIBLE);

      /*
      TODO:
      1. animate out the "start edit" FAB
      2. animate in the "done edit" FAB
      3. hide the static title (text-view)
      4. show the editable title (edit-text)
      5. make sure the editable title's text is the same as the static one
      6. optional (HARD!) make the keyboard to open with the edit-text focused,
          so the user can start typing without the need another click on the edit-text

      to complete (1.) & (2.), start by just changing visibility. only add animations after everything else is ready
       */
    });

    // handle clicks on "done edit"
    fabEditDone.setOnClickListener(v -> {
      isEditing=false;
      String newTitle = editTextTitle.getText().toString();
      textViewTitle.setText(newTitle);
      editTextTitle.setText(newTitle);
      //return to main activity
      fabStartEdit.setVisibility(View.VISIBLE);
      textViewTitle.setVisibility(View.VISIBLE);
      fabEditDone.setVisibility(View.GONE);
      editTextTitle.setVisibility(View.GONE);
      /*
      TODO:
      1. animate out the "done edit" FAB
      2. animate in the "start edit" FAB
      3. take the text from the user's input in the edit-text and put it inside the static text-view
      4. show the static title (text-view)
      5. hide the editable title (edit-text)
      6. make sure that the keyboard is closed

      to complete (1.) & (2.), start by just changing visibility. only add animations after everything else is ready
       */
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