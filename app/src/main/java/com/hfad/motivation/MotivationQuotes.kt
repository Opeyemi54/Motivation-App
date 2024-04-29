package com.hfad.motivation

class MotivationQuotes {

    companion object {
        fun getLifeQuotes(): List<QuotesDataClass> {
            val lifeQuotes = mutableListOf<QuotesDataClass>()
            val lifeQuote1 = QuotesDataClass(
                0,"Life is what happens when you are busy making other plans",
                "John Lennon"
            )
            lifeQuotes.add(lifeQuote1)

            val lifeQuote2 = QuotesDataClass(
                1,"Twenty years from now, you will be more disappointed by the things that you didn't do than by the ones you did do.",
                "Mark Twain"
            )
            lifeQuotes.add(lifeQuote2)

            val lifeQuote3 = QuotesDataClass(
                2,"The only person you are destined to become is the person you decide to be.",
                "Ralph Waldo"
            )
            lifeQuotes.add(lifeQuote3)

            val lifeQuote4 = QuotesDataClass(
                3,"The purpose of life is not to be happy., It is to be useful, to be honorable, to be compassionate, to have it make some difference that you have lived and lived well.",
                "Ralph Waldo"
            )
            lifeQuotes.add(lifeQuote4)

            return lifeQuotes
        }


        fun getMotivationQuotes(): List<QuotesDataClass> {
            val motivation = mutableListOf<QuotesDataClass>()
            val motivation1 = QuotesDataClass(
                0,"I wasn't there to compete, I was there to win.",
                "Arnold Schwarzenegger"
            )
            motivation.add(motivation1)

            val motivation2 = QuotesDataClass(
                1,"Someone once told me growth and comfort do not coexist.",
                "Ginni Rometty"
            )
            motivation.add(motivation2)

            val motivation3 = QuotesDataClass(
                2,"It's not about how many times you fall that cunts. It's about how many times you get back up.",
                "Nelson Mandela"
            )
            motivation.add(motivation3)

            val motivation4 = QuotesDataClass(
                3,"The difference between ordinary and extraordinary is that little extra.",
                "Jimmy Johnson"
            )
            motivation.add(motivation4)
            return motivation
        }



        fun getLoveQuotes(): List<QuotesDataClass> {
            val loveQuotes = mutableListOf<QuotesDataClass>()
            val loveQuote1 = QuotesDataClass(
                0,"To love and to be loved is to feel the sun from both sides.",
                "David Viscott"
            )
            loveQuotes.add(loveQuote1)

            val loveQuote2 = QuotesDataClass(
                1,"You may not always be together but you will never be apart. For the greatest thing you will ever learn is to love and be loved in return.",
                "Moulin Rouge"
            )
            loveQuotes.add(loveQuote2)

            val loveQuote3 = QuotesDataClass(
                2,"Love is not about finding someone to complete you; it's about finding someone who accepts you completely.",
                "Roy croft"
            )
            loveQuotes.add(loveQuote3)

            val loveQuote4 = QuotesDataClass(
                3,"A successful marriage requires falling in love many times, always with the same person.",
                "Mignon McLaughlin"
            )
            loveQuotes.add(loveQuote4)
            return loveQuotes
        }



        fun getSuccessQuotes(): List<QuotesDataClass> {
            val successQuotes = mutableListOf<QuotesDataClass>()
            val successQuotes1 = QuotesDataClass(
                0,"Success is stumbling from failure to failure with no loss of enthusiasm.",
                "Winston Churchill"
            )
            successQuotes.add(successQuotes1)

            val successQuotes2 = QuotesDataClass(
                1,"The only way to do great work is to love what you do. if you haven't found it yet, keep looking.",
                "Steve Jobs"
            )
            successQuotes.add(successQuotes2)

            val successQuotes3 = QuotesDataClass(
                2,"There are three ways to ultimate success: First, be kind. Second, be kind. Third, be kind.",
                "Henry James"
            )
            successQuotes.add(successQuotes3)

            val successQuotes4 = QuotesDataClass(
                3,"Don't be afraid to give up the good to go for the great.",
                "John D. Rockefeller"
            )
            successQuotes.add(successQuotes4)
            return successQuotes
        }



        fun getEnglishQuotes(): List<QuotesDataClass> {
            val englishQuotes = mutableListOf<QuotesDataClass>()
            val englishQuotes1 = QuotesDataClass(
                0,"Curiosity is the very first of the inventions of a child's genius.",
                "Geoffrey Chaucer"
            )
            englishQuotes.add(englishQuotes1)

            val englishQuotes2 = QuotesDataClass(
                1,"A dream you don't chase remains a dream. A goal you don't chase set remains a wish. A chance you don't take remains a regret",
                "Lewis Carroll"
            )
            englishQuotes.add(englishQuotes2)

            val englishQuotes3 = QuotesDataClass(
                2,"It is not the mountain we conquer, but ourselves.",
                "Edmund Hillary"
            )
            englishQuotes.add(englishQuotes3)

            val englishQuotes4 = QuotesDataClass(
                3,"I am not afraid of tomorrow, for i have learned from yesterday.",
                "Jane Austen"
            )
            englishQuotes.add(englishQuotes4)

            return englishQuotes
        }

    }
}