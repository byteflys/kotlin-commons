package x.kotlin.commons.preference

import x.kotlin.commons.preference.PreferenceValues.DEFAULT_PREFERENCE_NAME
import x.kotlin.commons.preference.PreferenceValues.SCOPE_MEMORY
import x.kotlin.commons.preference.PreferenceValues.SCOPE_PERSISTENT

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