package com.example.beatbox

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class SoundViewModelTest {
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel
    private lateinit var beatBox: BeatBox
    @Before
    fun setUp() {
        beatBox = mock(BeatBox::class.java)
        sound= Sound("assetPath")
        subject= SoundViewModel(beatBox)
        subject.sound=sound
    }
    @Test
    fun exposesSoundNameAsTitle(){
        org.hamcrest.MatcherAssert.assertThat(subject.title,`is`(sound.name))
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()
        verify(beatBox).play(sound)
    }
}