package com.zaketn.quadraticequation

import java.lang.Exception
import java.lang.IllegalArgumentException
import kotlin.math.pow
import kotlin.math.sqrt

class QuadraticEquation(
    private val A: Float,
    private val B: Float,
    private val C: Float,
) {
    val discriminant: Float
        get() {
            return B.pow(2) - 4 * (A * C)
        }

    fun findRoots(): FloatArray {
        val roots = FloatArray(2)

        if(discriminant > 0 && A > 0){
            roots[0] = (-B + sqrt(discriminant)) / 2 * A
            roots[1] = (-B - sqrt(discriminant)) / 2 * A
        } else if(discriminant == 0f && A > 0){
            roots[0] = -B / 2 * A
        } else throw IllegalArgumentException()

        return roots
    }
}
