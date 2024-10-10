package x.kotlin.commons.preference

import io.github.hellogoogle2000.kotlin.commons.preference.PreferenceValues.DEFAULT_PREFERENCE_NAME
import io.github.hellogoogle2000.kotlin.commons.preference.PreferenceValues.SCOPE_MEMORY
import io.github.hellogoogle2000.kotlin.commons.preference.PreferenceValues.SCOPE_PERSISTENT

object PreferenceX {

    val memory = get(SCOPE_MEMORY)
    val persistent = get(SCOPE_PERSISTENT)

    fun get(
        scope: String,
        name: String = DEFAULT_PREFERENCE_NAME
    ): Preference {
        TODO()
    }
}