/*
 * Nines - A lot of nines.
 * Written in 2021 by xf8b <unknownperson102424@pm.me>
 * To the extent possible under law, the author(s) have dedicated all copyright and related and neighboring rights to this software to the public domain worldwide. This software is distributed without any warranty.
 * You should have received a copy of the CC0 Public Domain Dedication along with this software. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */

@file:JvmName("Bruh")

package io.github.xf8b.nines

import com.beust.jcommander.IStringConverter
import com.beust.jcommander.JCommander
import com.beust.jcommander.Parameter
import java.math.BigInteger
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import kotlin.system.exitProcess

fun main(vararg args: String) {
    val arguments = Arguments()

    val jCommander = JCommander.newBuilder()
        .addObject(arguments)
        .programName("Nines")
        .build()

    if (args.isNotEmpty() && args[0].equals("help", ignoreCase = true)) {
        jCommander.usage()
        exitProcess(0)
    } else {
        jCommander.parse(*args)
    }

    val bruhAmount = arguments.amount
    var i = BigInteger.ONE

    while (true) {
        if (i > bruhAmount) break

        if (arguments.newLines) println("bruh") else print("bruh ")

        i++
    }
}

private fun userResource(path: String) = Path.of(System.getProperty("user.dir")).resolve(path)
private fun String.toBigInteger() = BigInteger(this)

class Arguments {
    @Parameter(
        names = ["-n", "--newLines"],
        description = "Prints using new lines",
        converter = BooleanConverter::class
    )
    var newLines = true

    @Parameter(
        names = ["-a", "--amount"],
        description = "Amount of bruhs",
        converter = BigIntegerConverter::class
    )
    var amount = Files.readAllBytes(userResource("amount.txt"))
        .toString(charset = Charset.defaultCharset())
        .toBigInteger()
}

class BooleanConverter : IStringConverter<Boolean> {
    override fun convert(value: String) = value.toBoolean()
}

class BigIntegerConverter : IStringConverter<BigInteger> {
    override fun convert(value: String) = BigInteger(value)
}