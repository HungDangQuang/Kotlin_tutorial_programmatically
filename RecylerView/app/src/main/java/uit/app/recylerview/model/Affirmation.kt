package uit.app.recylerview.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResourcesId: Int,
    @DrawableRes val imageResourceId: Int) {
}