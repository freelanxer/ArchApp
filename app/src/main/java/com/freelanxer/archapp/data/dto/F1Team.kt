package com.freelanxer.archapp.data.dto

import androidx.annotation.DrawableRes
import com.freelanxer.archapp.R

/**
 * F1 Team
 */
sealed class F1Team(
    val name: String,
    @DrawableRes
    val teamColor: Int,
    @DrawableRes
    val teamLogo: Int,
) {
    data object RedBullRacing: F1Team(
        name = "Red Bull Racing",
        teamColor = R.drawable.bg_team_red_bull,
        teamLogo = R.drawable.ic_team_logo_red_bull,
    )
    data object Ferrari: F1Team(
        name = "Ferrari",
        teamColor = R.drawable.bg_team_ferrari,
        teamLogo = R.drawable.ic_team_logo_ferrari,
    )
    data object McLaren: F1Team(
        name = "McLaren",
        teamColor = R.drawable.bg_team_mclaren,
        teamLogo = R.drawable.ic_team_logo_mclaren,
    )
    data object Mercedes: F1Team(
        name = "Mercedes",
        teamColor = R.drawable.bg_team_mercedes,
        teamLogo = R.drawable.ic_team_logo_mercedes,
    )
    data object AstonMartin: F1Team(
        name = "Aston Martin",
        teamColor = R.drawable.bg_team_aston_martin,
        teamLogo = R.drawable.ic_team_logo_aston_martin,
    )
    data object RB: F1Team(
        name = "RB",
        teamColor = R.drawable.bg_team_rb,
        teamLogo = R.drawable.ic_team_logo_rb,
    )
    data object Alpine: F1Team(
        name = "Alpine",
        teamColor = R.drawable.bg_team_alpine,
        teamLogo = R.drawable.ic_team_logo_alpine,
    )
    data object Williams: F1Team(
        name = "Williams",
        teamColor = R.drawable.bg_team_williams,
        teamLogo = R.drawable.ic_team_logo_williams,
    )
    data object Kick: F1Team(
        name = "Kick Sauber",
        teamColor = R.drawable.bg_team_kick_sauber,
        teamLogo = R.drawable.ic_team_logo_kick_sauber,
    )
    data object Haas: F1Team(
        name = "Haas F1 Team",
        teamColor = R.drawable.bg_team_haas,
        teamLogo = R.drawable.ic_team_logo_haas,
    )

    companion object {
        fun getF1TeamByName(name: String): F1Team = when (name) {
            RedBullRacing.name -> RedBullRacing
            Ferrari.name -> Ferrari
            McLaren.name -> McLaren
            Mercedes.name -> Mercedes
            AstonMartin.name -> AstonMartin
            RB.name -> RB
            Alpine.name -> Alpine
            Williams.name -> Williams
            Kick.name -> Kick
            Haas.name -> Haas
            else -> Haas
        }
    }

}