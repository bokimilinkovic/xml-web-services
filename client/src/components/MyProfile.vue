<template>
    <div>
        <b-navbar type="light" variant="light">
            <div class="container">
                <b-navbar-nav style="margin-left:0.9rem">
                    <b-nav-item @click="showClientAds()"> My Ads </b-nav-item>

                    <b-nav-item @click="showClientCars()"> My Cars </b-nav-item>

                    <b-nav-item-dropdown text="My Bookings">
                        <b-dropdown-item
                            data-toggle="modal"
                            data-target="#newbooking"
                        >
                            <b-icon
                                icon="calendar-plus-fill"
                                aria-hidden="true"
                                variant="dark"
                            ></b-icon>
                            Create Booking
                        </b-dropdown-item>
                        <b-dropdown-item @click="showClientBookings()">
                            <b-icon
                                icon="calendar3-fill"
                                aria-hidden="true"
                                variant="dark"
                            ></b-icon>
                            All Bookings
                        </b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>

                <b-navbar-nav style="margin-right:0.9rem">

                    <b-nav-item @click="showPrices()" right>
                        <b-icon
                            icon="wallet2"
                            aria-hidden="true"
                            variant="dark"
                        ></b-icon>
                        My Prices
                    </b-nav-item>



                     <b-nav-item @click="showRates()" right>
                        <b-icon
                            icon="star"
                            aria-hidden="true"
                            variant="dark"
                        ></b-icon>
                        My Rates
                    </b-nav-item>

                    <b-nav-item @click="showMessages()" right>
                        <b-icon
                            icon="chat-dots"
                            aria-hidden="true"
                            variant="dark"
                        ></b-icon>
                        Messages
                    </b-nav-item>

                    <b-nav-item @click="showReports()" right>
                        <b-icon
                            icon="clipboard-data"
                            aria-hidden="true"
                            variant="dark"
                        ></b-icon>
                        Statistics
                    </b-nav-item>

                    <b-nav-item @click="showClientCart()" right>
                        <b-icon
                            icon="cart"
                            aria-hidden="true"
                            variant="dark"
                        ></b-icon>
                        My Cart
                    </b-nav-item>
                
                </b-navbar-nav>
            </div>
        </b-navbar>
        <BookingSubmitForm />
        <AllBookings v-if="this.boolbook" />
        <ClientCars v-if="this.boolcars" />
        <ClientAds v-if="this.boolads" />
        <Cart v-if="this.boolcart" />
        <Reports v-if="this.boolrep" />
    </div>
</template>

<script>
import ClientCars from "./ClientCars";
import ClientAds from "./ClientAds";
import BookingSubmitForm from "./BookingSubmitForm";
import Cart from "./Cart";
import AllBookings from "./AllBookings";
import Reports from "./Reports";

export default {
    data() {
        return {
            boolcars: false,
            boolads: false,
            boolbook: false,
            boolcart: false,
            boolrep: false,
        };
    },
    components: {
        ClientCars,
        ClientAds,
        BookingSubmitForm,
        Cart,
        AllBookings,
        Reports,
    },
    methods: {
        showClientCars() {
            this.boolcars = true;
            this.boolads = false;
            this.boolbook = false;
            this.boolcart = false;
            this.boolrep = false;
        },
        showClientAds() {
            this.boolads = true;
            this.boolcars = false;
            this.boolbook = false;
            this.boolcart = false;
            this.boolrep = false;
        },
        showClientBookings() {
            this.boolads = false;
            this.boolcars = false;
            this.boolbook = true;
            this.boolcart = false;
            this.boolrep = false;
        },
        showClientCart() {
            this.boolads = false;
            this.boolcars = false;
            this.boolbook = false;
            this.boolcart = true;
            this.boolrep = false;
        },
        showReports() {
            this.boolads = false;
            this.boolcars = false;
            this.boolbook = false;
            this.boolcart = false;
            this.boolrep = true;
        },
        showPrices(){
            this.$router.push("/pricelists");
        },

        showMessages(){
            this.$router.push("/messages");
        },
        showRates(){
            this.$router.push("/rates");
        }
    },
    created() {},
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
