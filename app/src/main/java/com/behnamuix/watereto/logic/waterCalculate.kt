package com.behnamuix.watereto.logic

fun waterCalculate_ML(weight: Float): Float {
    var valueNeedWater = 0f
    valueNeedWater = weight * 0.035f * 1000
    return valueNeedWater


}

fun glassCalculate(water_ml: Int): Int {
    var glass_count = water_ml
    if (glass_count >= 0) {
        glass_count = water_ml / 250
        return glass_count
    } else {
        glass_count = 1
        return glass_count
    }


}

data class waterState(
    val need: Float,
    val progress: Float
)

fun drinkWater(
    waterNeed_ml: Float,
    waterProgress: Float,
    glassCount: Int
): waterState {

    var need = waterNeed_ml
    var progress = waterProgress

    if (need >= 0) {
        need -= 250

        progress += 150 / glassCount.toFloat()


        if (need < 200) {
            need = 0f
        }
    }

    return waterState(need, progress)
}

fun BackwardWater(
    waterNeed_ml: Float,
    waterProgress: Float,
    glassCount: Int
): waterState {

    var need = waterNeed_ml
    var progress = waterProgress

    if (need >= waterNeed_ml) {
        need += 250
        progress -= 150 / glassCount.toFloat()

        if (need < 200) {
            need = 0f
        }
    }

    return waterState(need, progress)
}

