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
import  {RendezVousDto}  from '/pages/controller/model/RendezVous.model';

const View = ({visible,onClose,selectedItem}) => {

    const emptyItem = new RendezVousDto();
    const [item, setItem] = useState<RendezVousDto>(emptyItem);
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
<Dialog visible={visible} style={{width: '70vw'}} header="RendezVous Details" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header="RendezVous">
    <div className="formgrid grid">

                <div className="field col-6">
                    <label htmlFor="patient">Patient</label>
                    <Dropdown  id="patientDropdown"  value={selectedItem?.patient?.email}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="center">Center</label>
                    <Dropdown  id="centerDropdown"  value={selectedItem?.center?.libelle}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="medecin">Medecin</label>
                    <Dropdown  id="medecinDropdown"  value={selectedItem?.medecin?.email}  disabled  />
                </div>
        <div className="field col-6">
            <label htmlFor="datePriseRdv">DatePriseRdv</label>
            <Calendar id="datePriseRdv" value={selectedItem?.datePriseRdv} disabled dateFormat="dd/mm/yy" showTime />
        </div>

                <div className="field col-6">
                    <label htmlFor="categorieRdv">CategorieRdv</label>
                    <Dropdown  id="categorieRdvDropdown"  value={selectedItem?.categorieRdv?.libelle}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="etatRendezVous">EtatRendezVous</label>
                    <Dropdown  id="etatRendezVousDropdown"  value={selectedItem?.etatRendezVous?.libelle}  disabled  />
                </div>
        </div>
</TabPanel>
    <TabPanel header="Doses">
                <div className="card">
                    <DataTable value={selectedItem?.doses} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="etatDose.libelle" header="Etat dose"></Column>
                                <Column field="dateDebutPrevu" header="Date debut prevu"></Column>
                                <Column field="dateDebutEffectif" header="Date debut effectif"></Column>
                                <Column field="description" header="Description"></Column>
                    </DataTable>
                </div>
        </TabPanel>
    <TabPanel header="effetIndesirables">
                <div className="card">
                    <DataTable value={selectedItem?.effetIndesirables} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="dateFait" header="Date fait"></Column>
                                <Column field="description" header="Description"></Column>
                    </DataTable>
                </div>
        </TabPanel>
</TabView>
</Dialog>
);
};
export default View;