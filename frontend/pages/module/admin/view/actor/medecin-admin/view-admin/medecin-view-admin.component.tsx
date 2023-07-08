import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import {AxiosResponse} from 'axios';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import { InputSwitch } from "primereact/inputswitch";
import {MultiSelect} from "primereact/multiselect";
import  {MedecinDto}  from '/pages/controller/model/Medecin.model';

const View = ({visible,onClose,selectedItem}) => {

    const emptyItem = new MedecinDto();
    const [item, setItem] = useState<MedecinDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);

    useEffect(() => {
        setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, [selectedItem]);

    const onTabChange = (e: { index: number }) => {
        setActiveIndex(e.index);
    };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} /> < />
    );

return(
<Dialog visible={visible} style={{width: '70vw'}} header="Medecin Details" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header="Medecin">
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="email">Email</label>
                <InputText id="email" value={selectedItem?.email} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="cin">Cin</label>
                <InputText id="cin" value={selectedItem?.cin} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="nom">Nom</label>
                <InputText id="nom" value={selectedItem?.nom} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="prenom">Prenom</label>
                <InputText id="prenom" value={selectedItem?.prenom} disabled   />
            </div>

                <div className="field col-6">
                    <label htmlFor="center">Center</label>
                    <Dropdown  id="centerDropdown"  value={selectedItem?.center?.libelle}  disabled  />
                </div>
        </div>
</TabPanel>
</TabView>
</Dialog>
);
};
export default View;