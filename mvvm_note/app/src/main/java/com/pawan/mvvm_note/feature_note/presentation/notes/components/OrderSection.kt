package com.pawan.mvvm_note.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pawan.mvvm_note.feature_note.domain.utils.NoteOrder
import com.pawan.mvvm_note.feature_note.domain.utils.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit,
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                "Title",
                noteOrder is NoteOrder.Title,
                { onOrderChange(NoteOrder.Title(noteOrder.orderType)) },
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                "Date",
                noteOrder is NoteOrder.Date,
                { onOrderChange(NoteOrder.Date(noteOrder.orderType)) },
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                "Color",
                noteOrder is NoteOrder.Color,
                { onOrderChange(NoteOrder.Color(noteOrder.orderType)) },
            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                "Ascending",
                noteOrder.orderType is OrderType.Ascending,
                { onOrderChange(noteOrder.copyWith(OrderType.Ascending)) },
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                "Descending",
                noteOrder is NoteOrder.Date,
                { onOrderChange(noteOrder.copyWith(OrderType.Descending)) },
            )


        }
    }
}