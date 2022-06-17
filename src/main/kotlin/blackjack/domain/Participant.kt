package blackjack.domain

abstract class Participant {

    abstract val playerCards: Cards
    abstract val name: String
    private var _blackJackStatus: BlackJackStatus = BlackJackStatus.INIT
    val blackJackStatus
        get() = _blackJackStatus

    abstract fun isDealer(): Boolean

    abstract fun getEarnAmount(participants: List<Player>, dealer: Dealer): Int

    fun addCard(card: Card) {
        this.playerCards.addCard(card)
        _blackJackStatus = playerCards.getBlackJackStatus()
    }

    fun setFirstDistributionBlackJack() {
        _blackJackStatus = playerCards.getBlackJackStatus()
    }

    fun setBlackJackStatusStay() {
        _blackJackStatus = BlackJackStatus.STAY
    }

    fun isHit(): Boolean {
        return this.blackJackStatus == BlackJackStatus.HIT
    }

    fun isBust(): Boolean {
        return this.blackJackStatus == BlackJackStatus.BUST
    }
}
