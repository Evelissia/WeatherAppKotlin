package com.example.weatherapp2.fragments
import android.app.AlertDialog
import android.content.Context
import android.widget.EditText
// Менеджер диалоговых окон для работы с поиском погоды по названию города
object DialogManager {
    // Функция для отображения диалогового окна поиска по названию города
    fun searchByNameDialog(context: Context, onClick: (String?) -> Unit){
        // Создание диалогового окна с помощью AlertDialog.Builder
        val builder = AlertDialog.Builder(context)
        val edName = EditText(context)
        builder.setView(edName)
        // Создание и настройка диалогового окна
        val dialog = builder.create()
        dialog.setTitle("City name: ")

        // Установка кнопки "OK" и обработка ее нажатия
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK"){_,_ ->
            onClick(edName.text.toString())
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel"){_,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }
    // Интерфейс слушателя для обработки событий диалогового окна
    interface Listener {
        // Метод, вызываемый при нажатии на кнопку "OK" в диалоговом окне
        fun onClick(name: String?)
    }
}