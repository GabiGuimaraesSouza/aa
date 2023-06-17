package com.example.dedalos.extensions
import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.*
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.Window
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.dedalos.MainActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//        .placeholder(R.drawable.ic_baseline_image_not_supported_24)
        .centerCrop()
        .into(this)
}

inline fun <reified T : Activity> Context.openActivity(
    options: Bundle? = null,
    finishWhenOpen: Boolean = false,
    finishStack: Boolean = false,
//    @AnimRes enterAnim: Int = R.anim.anim_frag_fade_in,
//    @AnimRes exitAnim: Int = R.anim.anim_frag_fade_out,
    noinline f: Intent.() -> Unit = {}
) {

    val intent = Intent(this, T::class.java)
    intent.f()
    if (finishStack) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    intent.putExtra("options", options)
    startActivity(intent)

    if (finishWhenOpen) (this as Activity).finish()

//    (this as Activity).overridePendingTransition(enterAnim, exitAnim)
}

fun View.viewVisible() {
    this.visibility = View.VISIBLE
}

fun View.viewInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.viewGone() {
    this.visibility = View.GONE
}

// Snackbar Extensions
fun View.showSnackbarRed(message: String) {
    val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    snackBar.setBackgroundTint(Color.RED)
    snackBar.show()
}

fun View.showSnackbar(message: String) {
    val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_SHORT)
    snackBar.show()
}

fun View.snackBarWithAction(
    message: String, actionLabel: String,
    block: () -> Unit
) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .setAction(actionLabel) {
            block()
        }
}

fun View.openCalendar(button: MaterialButton) {
    var cal = Calendar.getInstance()

    val dateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(myFormat)
            button.text = sdf.format(cal.time)

        }

    DatePickerDialog(
        context, dateSetListener,
        cal.get(Calendar.YEAR),
        cal.get(Calendar.MONTH),
        cal.get(Calendar.DAY_OF_MONTH)
    ).show()
}

fun alertNotification(ctx: Context, title: String, message: String) {
    val alertDialogBuilder = AlertDialog.Builder(ctx)
    alertDialogBuilder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
        dialog.dismiss()
    })
    alertDialogBuilder.setTitle(title)
    alertDialogBuilder.setMessage(Html.fromHtml(message))
        .show()
}

fun alert(ctx: Context, title: String, message: String) {
    val alertDialogBuilder = android.app.AlertDialog.Builder(ctx)
    val alertDialog = alertDialogBuilder.create()
    alertDialog.setTitle(title)
    alertDialog.setMessage(Html.fromHtml(message))
    alertDialog.show()
}

fun failureAlert(ctx: Context, title: String, message: String) {
    val alertDialogBuilder = android.app.AlertDialog.Builder(ctx)
    alertDialogBuilder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
        ctx.openActivity<MainActivity>(finishWhenOpen = true, finishStack = true) {  }
    })
    val alertDialog = alertDialogBuilder.create()
    alertDialog.setCancelable(false)
    alertDialog.setTitle(title)
    alertDialog.setMessage(Html.fromHtml(message))
    alertDialog.show()
}

fun loadingDialog(ctx: Context): Dialog {
    val loading = Dialog(ctx)
    loading.requestWindowFeature(Window.FEATURE_NO_TITLE)
//    loading.setContentView(R.layout.dialog_loading)
    loading.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    loading.setCanceledOnTouchOutside(false)
    loading.setCancelable(false)
    return loading
}

@RequiresApi(Build.VERSION_CODES.M)
fun Context.copyToClipboard(text: CharSequence) {
    val clipboard = getSystemService(ClipboardManager::class.java)
    val clip = ClipData.newPlainText("label", text)
    clipboard.setPrimaryClip(clip)
}